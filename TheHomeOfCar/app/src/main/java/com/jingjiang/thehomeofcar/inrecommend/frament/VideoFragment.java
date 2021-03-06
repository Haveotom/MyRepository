package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.VideoData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.VideoAdapter;
import com.jingjiang.thehomeofcar.inrecommend.invideo.AllVideoAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class VideoFragment extends BaseFragment implements View.OnClickListener {
    private AnimRFRecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private AllVideoAdapter allVideoAdapter;
    private LinearLayout allClick;
    private List<String> itemList;
    private TextView allTv;
    private Handler handler = new Handler();
    private VideoData data;


    @Override
    public int initLayout() {
        return R.layout.recommend_f_video;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.video_rv);
        videoAdapter = new VideoAdapter(getContext());
        recyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getContext()));
        //抽屉
        drawerLayout = bindView(R.id.video_drawer_layout);
        drawerListView = bindView(R.id.video_list_view);
        allVideoAdapter = new AllVideoAdapter(getContext());
        bindView(R.id.video_all_ll).setOnClickListener(this);
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//不可滑动
        bindView(R.id.video_drawer_close_tv).setOnClickListener(this);
        allTv = bindView(R.id.video_all_tv);
        recyclerView.setColor(Color.BLUE, Color.WHITE);
        //设置头部恢复动画的执行时间,默认是500毫秒
        recyclerView.setScaleRatio(1.7f);
    }


    @Override
    public void initData() {
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        VolleySingle.getInstance()._addRequest(
                "http://app.api.autohome.com.cn/autov5.0.0/news/videolist-pm2-vt0-s20-lastid0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<VideoData>() {
                    @Override
                    public void onResponse(final VideoData response) {
                        data = response;
                        videoAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), RecommendPublicAty.class);

                                String url = "http://v.autohome.com.cn/v_4_%@.html";
                                url = url.replace("%@", String.valueOf(data.getResult().getList().get(position).getId()));
                                intent.putExtra("URL", url);
                                startActivity(intent);
                            }
                        });
                        videoAdapter.setVideoData(data);

                    }
                }, VideoData.class);
//        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//去掉阴影部分
        recyclerView.setAdapter(videoAdapter);

        itemList = new ArrayList<>();
        itemList.add("全部");
        itemList.add("原创");
        itemList.add("实拍");
        itemList.add("试车");
        itemList.add("花边");
        itemList.add("事件");
        itemList.add("新车");
        itemList.add("广告");
        itemList.add("技术");
        itemList.add("二手车");
        allVideoAdapter.setItemList(itemList);
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
        boolean isRefresh;

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
                        recyclerView.refreshComplate();

                    } else {
                        loadData();
                        recyclerView.loadMoreComplate();
                    }

                }
            }, 2000);


        }
    }

    private void loadData() {
        String url = "";
        url = "http://app.api.autohome.com.cn/autov5.0.0/news/videolist-pm2-vt0-s20-lastid" +
                data.getResult().getList().get(data.getResult().getList().size() - 1).getLastid() + ".json";
        VolleySingle.getInstance()._addRequest(url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<VideoData>() {
                    @Override
                    public void onResponse(VideoData response) {
                        for (int i = 0; i < response.getResult().getList().size(); i++) {
                            data.getResult().getList().add(response.getResult().getList().get(i));
                        }
                        videoAdapter.setVideoData(data);

                    }
                }, VideoData.class);
        recyclerView.getAdapter().notifyDataSetChanged();


    }

    private void refreshData() {
        videoAdapter.setVideoData(data);
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_all_ll:
                drawerListView.setAdapter(allVideoAdapter);
                drawerLayout.openDrawer(GravityCompat.END);
                drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        allTv.setText(itemList.get(position));
                        drawerLayout.closeDrawer(GravityCompat.END);
                        allVideoAdapter.setColor(position);
                    }
                });
                break;
            case R.id.video_drawer_close_tv:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }
}
