package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewsData;
import com.jingjiang.thehomeofcar.bean.inrecommend.VideoData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewsAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;

/**
 * Created by dllo on 16/5/9.
 */
public class NewsFragment extends BaseFragment {
    private NewsAdapter newsAdapter;
    private AnimRFRecyclerView recyclerView;
    private NewsData data;
    private Handler handler = new Handler();

    @Override
    public int initLayout() {
        return R.layout.recommend_f_news;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.news_rv);
        newsAdapter = new NewsAdapter(getContext());
        recyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getContext()));
        recyclerView.setColor(Color.BLUE, Color.WHITE);


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
                        data = response;
                        newsAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), RecommendPublicAty.class);
                                String newsUrl = "http://cont.app.autohome.com.cn/autov4.2.5/content/News/newscontent-a2-pm1-v4.2.5-n%@-lz0-sp0-nt0-sa1-p0-c1-fs0-cw320.html";
                                newsUrl = newsUrl.replace("%@", String.valueOf(data.getResult().getNewslist().get(position).getId()));
                                intent.putExtra("URL", newsUrl);
                                startActivity(intent);
                            }
                        });
                        newsAdapter.setNewsData(data);
                    }
                }, NewsData.class);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//去掉阴影部分
        recyclerView.setAdapter(newsAdapter);
        initRefreshAndLoad();
    }

    private void initRefreshAndLoad() {
        recyclerView.setLoadDataListener(new AnimRFRecyclerView.LoadDataListener() {
            @Override
            public void onRefresh() {
                new Thread(new MyRunnable(true)).start();


            }

            @Override
            public void onLoadMore() {
                new Thread(new MyRunnable(false)).start();

            }
        });
        recyclerView.setRefresh(true);
    }

    class MyRunnable implements Runnable {
        private boolean isRefresh;

        public MyRunnable(boolean isRefresh) {
            this.isRefresh = isRefresh;
        }

        @Override
        public void run() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRefresh) {
                        refreshData();
                        refreshComplate();
                        recyclerView.refreshComplate();
                    } else {
                        loadData();
                        loadComplate();
                        recyclerView.loadMoreComplate();

                    }

                }
            }, 2000);


        }
    }

    private void loadComplate() {
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    private void loadData() {
        String url = "";
        url = "http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm2-c0-nt1-p2-s20-l%@.json";
        url = url.replace("%@", data.getResult().getNewslist().get(data.getResult().getNewslist().size() - 1).getLasttime());
        VolleySingle.getInstance()._addRequest(url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewsData>() {
                    @Override
                    public void onResponse(NewsData response) {
                        for (int i = 0; i < response.getResult().getNewslist().size(); i++) {
                            data.getResult().getNewslist().add(response.getResult().getNewslist().get(i));
                        }
                        newsAdapter.setNewsData(data);

                    }
                }, NewsData.class);

    }

    private void refreshComplate() {
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    private void refreshData() {
        newsAdapter.setNewsData(data);

    }


}
