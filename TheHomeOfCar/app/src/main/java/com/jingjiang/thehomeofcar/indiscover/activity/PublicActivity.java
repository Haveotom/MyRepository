package com.jingjiang.thehomeofcar.indiscover.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.inindividual.LoginAty;


/**
 * Created by dllo on 16/5/18.
 */
public class PublicActivity extends BaseActivity {
    private WebView webView;
    private TextView titleTv;
    private LinearLayout exit;

    @Override
    protected int getLayout() {
        return R.layout.aty_public;
    }

    @Override
    protected void initView() {
        titleTv = bindView(R.id.aty_public_title_tv);
        webView = bindView(R.id.aty_public_other_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//支持JavaScript脚本
        webSettings.setAllowFileAccess(true);//支持可以访问文件
        webSettings.setBuiltInZoomControls(true);//使页面支持缩放,显示缩放按钮
        //从来源处获取传过来的Extra值,,通过key值确定
        String url = getIntent().getStringExtra("url");

        titleTv.setText(getIntent().getStringExtra("title"));
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
        exit = bindView(R.id.aty_public_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        bindView(R.id.aty_forum_detail_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MyApplication.context, LoginAty.class));
//            }
//        });


    }

    @Override
    protected void initData() {

    }
}
