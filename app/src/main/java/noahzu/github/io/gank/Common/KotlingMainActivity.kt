package noahzu.github.io.gank.Common

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import noahzu.github.io.gank.CommitGank.CommitGankFragment
import noahzu.github.io.gank.HistoryGank.HistoryGankFragment
import noahzu.github.io.gank.LatestGank.LatestGankFragment

import noahzu.github.io.gank.R
import noahzu.github.io.gank.SearchGank.SearchGankActivity

class KotlingMainActivity : AppCompatActivity() {
    private lateinit var mDrawerLayout:DrawerLayout

    private lateinit var latestGankFragment : LatestGankFragment
    private lateinit var historyGankFragment : HistoryGankFragment
    private lateinit var navigationView : NavigationView

    private lateinit var preItem : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        latestGankFragment = LatestGankFragment.newInstance()
        historyGankFragment = HistoryGankFragment.newInstance()
        setupToolbarAndDrawer()
        initIndexFragment()
    }

    private fun setupToolbarAndDrawer() {
        val toolBar : Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mDrawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.nav_view) as NavigationView
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark)
        navigationView.setNavigationItemSelectedListener { item: MenuItem -> when(item.itemId){
            R.id.action_latest -> initLatestGank()
            R.id.action_history -> initHistoryGank()
            R.id.action_search -> initSearchGank()
            else -> showToast("点错了~")
        } }
    }

    private fun initLatestGank(): Boolean {
        supportActionBar?.setTitle("最新Gank")
        mDrawerLayout.closeDrawers()
        supportFragmentManager.beginTransaction().replace(R.id.contentFrame,latestGankFragment).commit()
        return true
    }

    private fun initHistoryGank(): Boolean {
        supportActionBar?.setTitle("历史Gank")
        mDrawerLayout.closeDrawers()
        supportFragmentManager.beginTransaction().replace(R.id.contentFrame,historyGankFragment).commit()
        return true
    }

    private fun initSearchGank(): Boolean {
        val intent = Intent(this,SearchGankActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun showToast(message: String): Boolean {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        return true
    }


    private fun initIndexFragment() {
        navigationView.menu.findItem(R.id.action_latest).setChecked(true)
        preItem = navigationView.menu.findItem(R.id.action_latest)
        initLatestGank()
    }
}
