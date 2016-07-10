package noahzu.github.io.gank.LatestGank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.R;

public class GankDetailActivity extends AppCompatActivity {

    private static final String TAG = "GankDetailActivity";
    public static String gank_detail = "gank";
    private Toolbar toolbar;
    private ProgressBar progress;
    private WebView webView;


    public static void actionStart(Context context ,Gank gank){
        Intent intent = new Intent(context,GankDetailActivity.class);
        intent.putExtra(GankDetailActivity.gank_detail,gank);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_detail);

        initView();
        loadWebData();
    }

    private void loadWebData() {
        Gank g = (Gank) getIntent().getSerializableExtra(GankDetailActivity.gank_detail);
        webView.loadUrl(g.url);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progress.setProgress(newProgress);
            }

        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        progress = (ProgressBar) findViewById(R.id.progress);
        webView = (WebView) findViewById(R.id.gank_detail_webview);
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
