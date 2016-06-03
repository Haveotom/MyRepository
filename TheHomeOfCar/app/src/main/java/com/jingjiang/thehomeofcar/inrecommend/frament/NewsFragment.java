package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewsData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewsAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

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
        VolleySingle.getInstance()._addRequest("http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm1-c0-nt1-p1-s30-l0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewsData>() {
                    @Override
                    public void onResponse(final NewsData response) {
                        newsAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(MyApplication.context, RecommendPublicAty.class);
                                String newsUrl = "http://cont.app.autohome.com.cn/autov4.2.5/content/News/newscontent-a2-pm1-v4.2.5-n%@-lz0-sp0-nt0-sa1-p0-c1-fs0-cw320.html";
                                newsUrl = newsUrl.replace("%@", String.valueOf(response.getResult().getNewslist().get(position).getId()));
                                intent.putExtra("URL", newsUrl);
                                startActivity(intent);
                            }
                        });
                        newsAdapter.setNewsData(response);
                    }
                }, NewsData.class);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//去掉阴影部分
        recyclerView.setAdapter(newsAdapter);
    }
}
