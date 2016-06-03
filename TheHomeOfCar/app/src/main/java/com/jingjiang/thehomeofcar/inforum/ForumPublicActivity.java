package com.jingjiang.thehomeofcar.inforum;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.inindividual.LoginAty;

/**
 * Created by dllo on 16/5/21.
 */
public class ForumPublicActivity extends BaseActivity {
    private WebView webView;
    private static final int WELLSELECTION = 1;
    private static final int HOTPOST = 2;
    private ImageView louzhuIv;

    @Override
    protected int getLayout() {
        return R.layout.aty_public_details;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.aty_forum_detail_webview);
        louzhuIv = bindView(R.id.aty_forum_detail_louzhu);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持JavaScript脚本
        webSettings.setAllowFileAccess(true);//支持可以访问文件
        webSettings.setBuiltInZoomControls(true);//使页面支持缩放

        Bundle bundle = getIntent().getExtras();//获取
        String id = new String(String.valueOf(bundle.getInt("ID")));

        String wellUrl = "http://forum.app.autohome.com.cn/autov5.0.0/forum/club/topiccontent-a2-pm2-v5.0.0-t%@-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw320.json";
        webView.loadUrl(wellUrl.replace("%@", id));

        String hotPostUrl = "http://forum.app.autohome.com.cn/forum_v5.7.0/forum/club/topiccontent-a2-pm2-v5.8.5-t%@-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw360.json";
        webView.loadUrl(hotPostUrl.replace("%@", id));

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
                startActivity(new Intent(ForumPublicActivity.this, LoginAty.class));
            }
        });


    }


    @Override
    protected void initData() {

    }


}
