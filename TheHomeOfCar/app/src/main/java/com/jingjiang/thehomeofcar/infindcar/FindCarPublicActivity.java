package com.jingjiang.thehomeofcar.infindcar;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;

/**
 * Created by dllo on 16/5/23.
 */
public class FindCarPublicActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.aty_findcar_public;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.findcar_public_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持JavaScript脚本
        webSettings.setAllowFileAccess(true);//支持可以访问文件
        webSettings.setBuiltInZoomControls(true);//使页面支持缩放

        String url = getIntent().getStringExtra("URL");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());

        findViewById(R.id.findcar_public_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {

    }
}
