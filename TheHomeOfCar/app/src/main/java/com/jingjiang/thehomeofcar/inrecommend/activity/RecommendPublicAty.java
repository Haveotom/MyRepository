package com.jingjiang.thehomeofcar.inrecommend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.android.volley.toolbox.StringRequest;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.inindividual.LoginAty;

/**
 * Created by dllo on 16/5/23.
 */
public class RecommendPublicAty extends BaseActivity {
    private WebView webView;
    private ImageView louzhuIv;

    @Override
    protected int getLayout() {
        return R.layout.aty_public_details;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.aty_forum_detail_webview);
        louzhuIv = bindView(R.id.aty_forum_detail_louzhu);
        louzhuIv.setVisibility(View.INVISIBLE);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持JavaScript脚本
        webSettings.setAllowFileAccess(true);//支持可以访问文件
        webSettings.setBuiltInZoomControls(true);//使页面支持缩放

        String url = getIntent().getStringExtra("URL");
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient());

        bindView(R.id.aty_forum_detail_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bindView(R.id.aty_forum_detail_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyApplication.context, LoginAty.class));
            }
        });

    }

    @Override
    protected void initData() {

    }
}
