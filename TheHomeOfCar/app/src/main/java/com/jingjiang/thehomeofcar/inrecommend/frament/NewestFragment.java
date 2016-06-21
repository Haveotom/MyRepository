package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewestData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;
import com.youth.banner.Banner;


/**
 * Created by dllo on 16/5/9.
 */
public class NewestFragment extends BaseFragment {
    private NewestAdapter newestAdapter;
    private AnimRFRecyclerView recyclerView;
    //刷新
    private View header;
    private Handler handler = new Handler();
    //轮播图
    private NewestData data;
    private Banner banner;


    @Override
    public int initLayout() {
        return R.layout.recommend_f_newest;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.newest_rv);
//        header = bindView(R.id.newest_header_rv);
        header = LayoutInflater.from(getContext()).inflate(R.layout.recommend_f_newest_header, null);
//        refresh = bindView(R.id.newest_refresh);
//        refresh.setOnRefreshListener(this);
        newestAdapter = new NewestAdapter(getContext());
        recyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getContext()));///
//        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setColor(Color.BLUE, Color.WHITE);
        //设置头部恢复动画的执行时间,默认是500毫秒
        recyclerView.setHeaderImageDurationMillis(500);
        recyclerView.setScaleRatio(1.7f);

        recyclerView.addHeaderView(header);

        banner = (Banner) header.findViewById(R.id.newest_recycle_picture);


    }

    @Override
    public void initData() {


        //轮播图
        VolleySingle.getInstance()._addRequest(
                "http://app.api.autohome.com.cn/autov4.2.5/news/newslist-a2-pm1-v4.2.5-c0-nt0-p1-s30-l0.html",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewestData>() {
                    @Override
                    public void onResponse(final NewestData response) {
                        data = response;
                        Log.d("NewestFragment", "data.getResult().getNewslist().size():" + data.getResult().getNewslist().size());
                        newestAdapter.setNewestData(response);
//
                        String[] images = new String[response.getResult().getFocusimg().size()];
                        for (int i = 0; i < response.getResult().getFocusimg().size(); i++) {
                            images[i] = response.getResult().getFocusimg().get(i).getImgurl();
                        }
                        banner.setDelayTime(3000);
                        banner.setImages(images);
                        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
                            @Override
                            public void OnBannerClick(View view, int position) {
                                Intent intent = new Intent(getContext(), RecommendPublicAty.class);
                                String recycleUrl = "";
                                //实现点击事件
                                if (data.getResult().getFocusimg().get(position - 1).getJumpurl() != "") {
                                    intent.putExtra("URL", data.getResult().getFocusimg().get(position - 1).getJumpurl());
                                    startActivity(intent);
                                } else if (data.getResult().getFocusimg().get(position - 1).getJumpurl() == "") {

                                    if (data.getResult().getFocusimg().get(position - 1).getMediatype() == 1) {
                                        recycleUrl = "http://cont.app.autohome.com.cn/autov5.0.0/content/news/newscontent-n%@-t0.json";

                                    } else if (data.getResult().getFocusimg().get(position - 1).getMediatype() == 2) {
                                        recycleUrl = "http://v.autohome.com.cn/v_4_%@.html";
                                    } else {
                                        recycleUrl = "http://forum.app.autohome.com.cn/autov5.0.0/forum/club/topiccontent-a2-pm2-v5.0.0-t%@-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw320.json";
                                    }
                                    recycleUrl = recycleUrl.replace("%@", String.valueOf(data.getResult().getFocusimg().get(position - 1).getId()));
                                    intent.putExtra("URL", recycleUrl);
                                    startActivity(intent);

                                }
                            }

                        });
                    }

                }, NewestData.class);

        //http://223.99.255.20/news.app.autohome.com.cn/news_v5.9.0/news/shuokelist-pm2-s20-lastid0.json
        //http://cont.app.autohome.com.cn/cont_v5.8.0/content/news/shuokecontent-a2-pm2-v5.9.0-n520122-nt0-lz0-p1-fs0-cw360.json
        newestAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MyApplication.context, RecommendPublicAty.class);
                String url = "";
                if (data.getResult().getNewslist().get(position).getMediatype() == 3) {
                    url = "http://v.autohome.com.cn/v_4_%@.html";

                } else if (data.getResult().getNewslist().get(position).getMediatype() == 2) {//说客
                    url = "http://cont.app.autohome.com.cn/cont_v5.8.0/content/news/shuokecontent-a2-pm2-v5.9.0-n%@-nt0-lz0-p1-fs0-cw360.json ";

                } else if (data.getResult().getNewslist().get(position).getMediatype() == 5) {
                    url = "http://forum.app.autohome.com.cn/autov5.0.0/forum/club/topiccontent-a2-pm2-v5.0.0-t%@-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw320.json";
                } else {
                    url = "http://cont.app.autohome.com.cn/autov4.2.5/content/News/newscontent-a2-pm1-v4.2.5-n%@-lz0-sp0-nt0-sa1-p0-c1-fs0-cw320.html";

                }
                url = url.replace("%@", String.valueOf(data.getResult().getNewslist().get(position).getId()));
                intent.putExtra("URL", url);
                startActivity(intent);

            }


        });

        recyclerView.setAdapter(newestAdapter);

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



    }

    class MyRunnable implements Runnable {
        boolean isRefesh;

        public MyRunnable(boolean isRefesh) {
            this.isRefesh = isRefesh;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (isRefesh) {
                        newData();
                        refreshComplate();
                        //刷新完成后调用,必须在UI线程中
                        recyclerView.refreshComplate();
                    } else {
                        addData();
                        loadMoreComplate();
                        //加载更多完成后调用
                        recyclerView.loadMoreComplate();
                    }
                }
            });

        }


    }

    private void refreshComplate() {
        recyclerView.setRefresh(true);
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    private void loadMoreComplate() {
        recyclerView.getAdapter().notifyDataSetChanged();

    }


    private void addData() {

        String url = "";
        url = "http://app.api.autohome.com.cn/autov4.2.5/news/newslist-a2-pm1-v4.2.5-c0-nt0-p%ld-s30-l%@.html";
        url = url.replace("%@", data.getResult().getNewslist().get(data.getResult().getNewslist().size() - 1).getLasttime());
        url = url.replace("%ld", String.valueOf(data.getResult().getNewslist().get(data.getResult().getNewslist().size() - 1).getId()));
        VolleySingle.getInstance()._addRequest(url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewestData>() {
                    @Override
                    public void onResponse(NewestData response) {
                        for (int i = 0; i < response.getResult().getNewslist().size(); i++) {
                            data.getResult().getNewslist().add(response.getResult().getNewslist().get(i));
                        }
                        Log.d("NewestFragment", "data.getResult().getNewslist().size():" + "aa" + data.getResult().getNewslist().size());

                        newestAdapter.setNewestData(data);

                    }
                }, NewestData.class);


    }


    private void newData() {
        recyclerView.setRefresh(true);
        newestAdapter.setNewestData(data);

    }

}
