package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;

/**
 * Created by dllo on 16/5/10.
 */


public class SecondCarFragment extends BaseFragment {
    private WebView webView;


    @Override
    public int initLayout() {
        return R.layout.findcar_f_secondcar;
    }

    @Override
    public void initView() {
        webView = bindView(R.id.findcar_secondcar_webview);
        WebSettings webSettings = webView.getSettings();
        //允许访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持JavaScript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置显示缩放按钮
        webSettings.setBuiltInZoomControls(true);
        //支持缩放
        webSettings.setSupportZoom(true);
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        webView.loadUrl("http://m.che168.com/dalian/list/?sourcename=mainapp&pvareaid=102254");
        // 默认情况下，点击webview中的链接
        // 会使用Android系统自带的浏览器打开这个链接。
        // 如果希望点击链接继续在我们自己的Browser中响应，
        // 必须覆盖 webview的WebViewClient对象：
        //这样的话就默认在本页打开网页
        webView.setWebViewClient(new WebViewClient());


    }


    @Override
    public void initData() {

    }
}
