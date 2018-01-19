package com.example.jason.sagy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class More extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        webView=(WebView) findViewById(R.id.web);
        webView.loadUrl("http://www.tn.gov.in/government/rajyasaba/48381");
    }
}
