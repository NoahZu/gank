package noahzu.github.io.gank.Common

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.squareup.picasso.Picasso
import noahzu.github.io.gank.R

/**
 * Created by zujinhao on 17/5/19.
 */
class PhotoActivity : AppCompatActivity() {

    private val IMAGEURL : String = "image_url"
    private lateinit var toolBar : Toolbar
    private lateinit var imageUrl : String
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_photo)
        imageUrl = intent.getStringExtra(IMAGEURL)

        initView()
        initToolbar()
        loadImage()
    }
    private fun initView() {
        imageView = findViewById(R.id.beauty_img) as ImageView
    }
    private fun initToolbar() {
        toolBar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolBar.setTitle("关于")
        toolBar.setNavigationOnClickListener { finish() }
    }

    private fun loadImage() {
        Picasso.with(this).load(imageUrl).into(imageView)
    }
}