package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewsData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.FastReportAdapter;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewsAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class NewsFragment extends BaseFragment {
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.recommend_f_news;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.news_rv);
        newsAdapter = new NewsAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    public void initData() {
        GsonRequest<NewsData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm1-c0-nt1-p1-s30-l0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewsData>() {
            @Override
            public void onResponse(NewsData response) {
                newsAdapter.setNewsData(response);


            }
        }, NewsData.class);
        MyRequestQueue.getRequestQueue().add(gsonRequest);

        recyclerView.setAdapter(newsAdapter);
    }
}
