package com.bawei.dengxianchaoyuekao20191127;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Info extends AppCompatActivity {
    WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        webView=findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/info.html");

        webView.addJavascriptInterface(new jsdemo(),"title");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("file:///android_asset/info.html");
                return true;
            }
        });



    }


    class jsdemo{
        @JavascriptInterface
        public void viewport(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:show('10')");
                }
            });
        }
    }
}
