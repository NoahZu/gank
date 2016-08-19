package noahzu.github.io.gank.Common;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import noahzu.github.io.gank.HistoryGank.HistoryGankFragment;
import noahzu.github.io.gank.LatestGank.LatestGankFragment;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.SearchGank.SearchGankActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private LatestGankFragment latestGankFragment;
    private HistoryGankFragment historyGankFragment;
    private LatestGankFragment f3;
    private LatestGankFragment f4;
    private NavigationView navigationView;
    private MenuItem preItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbarAndDrawer();
        initIndexFragment();
    }

    private void initIndexFragment() {
        navigationView.getMenu().findItem(R.id.action_latest).setChecked(true);
        preItem = navigationView.getMenu().findItem(R.id.action_latest);
        initLatestGank();
    }

    private void setupToolbarAndDrawer() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_latest:
                        initLatestGank();
                        break;
                    case R.id.action_history:
                        initHistoryGank();
                        break;
                    case R.id.action_search:
                        initSearchGank();
                        break;
                    case R.id.action_commit:
                        initCommitGank();
                        break;
                }
                if (item.getItemId() != R.id.action_search){
                    preItem.setChecked(false);
                    item.setChecked(true);
                    preItem = item;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initCommitGank() {
        getSupportActionBar().setTitle("提交Gank");
        mDrawerLayout.closeDrawers();
        if(f4 == null ){
            f4 = LatestGankFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame,f4)
                .commit();
    }

    private void initSearchGank() {
        startActivity(new Intent(MainActivity.this, SearchGankActivity.class));
    }

    private void initHistoryGank() {
        getSupportActionBar().setTitle("历史Gank");
        mDrawerLayout.closeDrawers();
        if(historyGankFragment == null ){
            historyGankFragment = HistoryGankFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, historyGankFragment)
                .commit();
    }

    private void initLatestGank() {
        getSupportActionBar().setTitle("最新Gank");
        mDrawerLayout.closeDrawers();
        if(latestGankFragment == null ){
            latestGankFragment = LatestGankFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, latestGankFragment)
                .commit();
    }
}
