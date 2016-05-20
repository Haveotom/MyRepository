package com.jingjiang.thehomeofcar.indiscover.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;


/**
 * Created by dllo on 16/5/18.
 */
public class PublicActivity extends BaseActivity {
    private WebView webView;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_public;
    }

    @Override
    protected void initView() {
        titleTv = bindView(R.id.aty_public_title_tv);
        webView = bindView(R.id.aty_public_other_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        /* 汽车音频 */
        String carMediaUrl = getIntent().getStringExtra("carMediaUrl");
        webView.loadUrl(carMediaUrl);

        /*  活动专区 */
        String activityUrl = getIntent().getStringExtra("activityUrl");
        webView.loadUrl(activityUrl);

        /* 车商城 */
        String extra = getIntent().getStringExtra("url");
        titleTv.setText(getIntent().getStringExtra("title"));
        webView.loadUrl(extra);

        /* 特惠热卖 */
        String hostSellUrl = getIntent().getStringExtra("hostSellUrl");
        webView.loadUrl(hostSellUrl);


        /* 品牌精品 */

        String brandUrl = getIntent().getStringExtra("brandUrl");
        webView.loadUrl(brandUrl);

        /* 商品列表 */
        String brandListUrl = getIntent().getStringExtra("brandListUrl");
        webView.loadUrl(brandListUrl);


        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void initData() {

    }
}
