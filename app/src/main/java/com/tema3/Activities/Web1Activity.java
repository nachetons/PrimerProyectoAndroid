package com.tema3.Activities;


import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.appcompat.app.AppCompatActivity;

import com.tema3.tema3ejemplo1.R;

public class Web1Activity extends AppCompatActivity{
    //Definimos las variables que vamos a usar
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview1);

        //Definimos la relacion de las variables creadas con los campos que pusimos en el xml
        webView = (WebView) findViewById(R.id.webview);


        //Enviamos al cliente del navegador creado en nuestra aplicacion con webView la url solicitada
        webView.setWebViewClient(new MyWebViewClient());
        String url = "http://facebook.com";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }

        //Este codigo es reciente ya que antes se enviaba el string de la url directamente y ahora te obligan a parsearlo
        private class MyWebViewClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest url) {
            view.loadUrl(url.getUrl().toString());
            return true;
        }
}
}
//TODO ES IGUAL EN LOS RESTANTES WEB ACTIVITY PERO CAMBIANDO LA URL