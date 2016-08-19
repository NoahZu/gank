package noahzu.github.io.gank.Common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import noahzu.github.io.gank.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PhotoActivity extends AppCompatActivity {
    public static final String IMAGE_URL = "image_url";

    private Toolbar toolbar;
    private String imageUrl;
    private ImageView imageView;
    private ImageView saveImage;
    private ImageView shareImage;
    private PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageUrl = getIntent().getStringExtra(IMAGE_URL);
        initView();
        initToolbar();
        loadImage();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.beauty_img);
        saveImage = (ImageView) findViewById(R.id.save_img);
        shareImage = (ImageView) findViewById(R.id.share_img);

    }

    private void loadImage() {
        Picasso.with(this).load(imageUrl).into(imageView);
        mAttacher = new PhotoViewAttacher(imageView);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示箭头
        toolbar.setTitle("关于");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//箭头的点击事件
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
