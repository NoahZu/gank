package noahzu.github.io.gank.Common;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import noahzu.github.io.gank.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
                return true;
            }
        });
    }

    private void initCommitGank() {
        mDrawerLayout.closeDrawers();
        Snackbar.make(getWindow().getDecorView(),"提交干货",Snackbar.LENGTH_LONG).show();
    }

    private void initSearchGank() {
        mDrawerLayout.closeDrawers();
        Snackbar.make(getWindow().getDecorView(),"检索干货",Snackbar.LENGTH_LONG).show();
    }

    private void initHistoryGank() {
        mDrawerLayout.closeDrawers();
        Snackbar.make(getWindow().getDecorView(),"历史干货",Snackbar.LENGTH_LONG).show();
    }

    private void initLatestGank() {
        mDrawerLayout.closeDrawers();
        Snackbar.make(getWindow().getDecorView(),"最新干货",Snackbar.LENGTH_LONG).show();
    }
}
