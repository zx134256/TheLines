package com.hy.thelines;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebviewActivity extends AppCompatActivity {
    private LinearLayout root = null;
    private WebView webView = null;

    private WebViewClient client = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            webView.loadUrl(s);
            return true;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //to get url and for load
        String url = getIntent().getStringExtra("url");

        root = findViewById(R.id.web_layout);
        webView = findViewById(R.id.web);
        webView.setWebViewClient(client);

        webView.loadUrl("www.baidu.com");
    }
}