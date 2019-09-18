package com.example.latihanwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        wv = findViewById (R.id.WebView);
        pb = findViewById (R.id.pb);
        wv.setWebViewClient (new myWebViewC ());
        wv.getSettings ().setJavaScriptEnabled (true);
        wv.loadUrl ("https://smkn4bdg.sch.id/");

    }

    public class myWebViewC extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted (view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished (view, url);
            pb.setVisibility (view.GONE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl (url);
            return super.shouldOverrideUrlLoading (view, url);

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack ()){
            wv.goBack();
            return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
