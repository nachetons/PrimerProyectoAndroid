package com.tema3.Activities;


import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.appcompat.app.AppCompatActivity;

import com.tema3.tema3ejemplo1.R;

public class Web3Activity extends AppCompatActivity{
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview3);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new Web3Activity.MyWebViewClient());
        String url = "http://whatsapp.com";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest url) {
            view.loadUrl(url.getUrl().toString());
            return true;
        }
    }
}