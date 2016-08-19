package noahzu.github.io.gank.SearchGank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import noahzu.github.io.gank.R;

public class SearchGankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_gank);


        SearchGankFragment searchGankFragment = new SearchGankFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.search_fragment_container,searchGankFragment)
                .commit();
    }
}
