package com.lau.finalschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webview = (WebView) findViewById(R.id.webview); //linking with view
        webview.getSettings().setJavaScriptEnabled(true); //enabaling js
        webview.setWebViewClient(new WebViewClient());//set client for this view
        webview.loadUrl(); //Link is the link of the website




    }
}