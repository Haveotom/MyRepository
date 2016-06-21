package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.FastReportData;
import com.jingjiang.thehomeofcar.inrecommend.activity.FastReportAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.FastReportAdapter;
import com.jingjiang.thehomeofcar.inrecommend.infastreport.AllBrandAdapter;
import com.jingjiang.thehomeofcar.inrecommend.infastreport.AllBrandData;
import com.jingjiang.thehomeofcar.inrecommend.infastreport.AllRankAdapter;
import com.jingjiang.thehomeofcar.inrecommend.infastreport.AllRankData;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;
import com.jingjiang.thehomeofcar.widget.VolleySingle;
import com.sch.rfview.AnimRFRecyclerView;
import com.sch.rfview.manager.AnimRFLinearLayoutManager;

import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class FastReportFragment extends BaseFragment implements View.OnClickListener {
    private AnimRFRecyclerView recyclerView;
    private FastReportAdapter fastReportAdapter;
    private AllBrandAdapter allBrandAdapter;
    private AllRankAdapter allRankAdapter;
    private ExpandableListView expandableListView;
    private DrawerLayout drawer;
    private LinearLayout allBrandLl, allRankLl;
    private TextView closeTv, allBrandTv, allRankTv;
    private Handler handler = new Handler();
    private FastReportData data;


    @Override
    public int initLayout() {
        return R.layout.recommend_f_fastreport;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.fastreport_rv);
        recyclerView.setLayoutManager(new AnimRFLinearLayoutManager(getContext()));
        fastReportAdapter = new FastReportAdapter(getContext());
        allBrandAdapter = new AllBrandAdapter(getContext());
        allRankAdapter = new AllRankAdapter(getContext());
        expandableListView = bindView(R.id.fastreport_expandable_lv);
        expandableListView.setGroupIndicator(null);
        closeTv = bindView(R.id.fastreport_drawer_close_tv);
        drawer = bindView(R.id.fastreport_drawer_layout);
        allBrandLl = bindView(R.id.fastreport_all_brand_ll);
        allRankLl = bindView(R.id.fastreport_all_rank_ll);
        allRankLl.setOnClickListener(this);
        allBrandLl.setOnClickListener(this);
        closeTv.setOnClickListener(this);
//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        allBrandTv = bindView(R.id.fastreport_all_brand_tv);
        allRankTv = bindView(R.id.fastreport_all_rank_tv);
        recyclerView.setColor(Color.BLUE, Color.WHITE);


    }

    //全部级别
    // http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/fastnewslevel-pm2-ts0.json
    // 全部品牌
    //http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/brandsfastnews-pm2-ts0.json
    @Override
    public void initData() {

        VolleySingle.getInstance()._addRequest("http://app.api.autohome.com.cn/autov5.0.0/news/fastnewslist-pm2-b0-l0-s20-lastid0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<FastReportData>() {
                    @Override
                    public void onResponse(final FastReportData response) {
                        data = response;
                        fastReportAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), FastReportAty.class);
                                int id = data.getResult().getList().get(position).getId();
                                intent.putExtra("ID", id);
                                startActivity(intent);
                            }
                        });

                        fastReportAdapter.setFastReportDatas(data);

                    }
                }, FastReportData.class);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//去掉阴影部分
        recyclerView.setAdapter(fastReportAdapter);
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
        boolean isRefreah;

        public MyRunnable(boolean isRefreah) {
            this.isRefreah = isRefreah;
        }

        @Override
        public void run() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRefreah) {
                        refreshData();
                        refreshComplate();
                        //刷新完成后调用
                        recyclerView.refreshComplate();

                    } else {
                        loadData();
                        loadMoreComplate();
                        //加载更多之后调用
                        recyclerView.loadMoreComplate();
                    }

                }
            }, 2000);


        }
    }


    private void loadData() {
        String url = "";
        url = "http://app.api.autohome.com.cn/autov5.0.0/news/fastnewslist-pm2-b0-l0-s20-lastid%@.json";
        url = url.replace("%@", data.getResult().getList().get(data.getResult().getList().size() - 1).getLastid());
        VolleySingle.getInstance()._addRequest(url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<FastReportData>() {
                    @Override
                    public void onResponse(FastReportData response) {
                        for (int i = 0; i < response.getResult().getList().size(); i++) {
                            data.getResult().getList().add(response.getResult().getList().get(i));
                        }
                        fastReportAdapter.setFastReportDatas(data);
                    }
                }, FastReportData.class);

    }

    private void refreshData() {
        fastReportAdapter.setFastReportDatas(data);

    }

    private void loadMoreComplate() {
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    private void refreshComplate() {
        recyclerView.getAdapter().notifyDataSetChanged();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fastreport_all_brand_ll:
                drawer.openDrawer(GravityCompat.END);
//                setAllBrand();
                VolleySingle.getInstance()._addRequest("http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/brandsfastnews-pm2-ts0.json",
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, new Response.Listener<AllBrandData>() {
                            @Override
                            public void onResponse(final AllBrandData response) {
                                //首次加载默认父item展开
                                if (response.getResult().getBrandlist().size() > 0) {
                                    for (int i = 0; i < response.getResult().getBrandlist().size(); i++) {
                                        expandableListView.expandGroup(i);
                                    }
                                }
                                //父item不能点击收缩
                                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                                    @Override
                                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                        return true;
                                    }
                                });
                                //子类
                                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                    @Override
                                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                                        allBrandTv.setText(response.getResult().getBrandlist().get(groupPosition).getList().
                                                get(childPosition).getName());
                                        drawer.closeDrawer(GravityCompat.END);


                                        return false;
                                    }
                                });

                                allBrandAdapter.setData(response);
                            }
                        }, AllBrandData.class);
                expandableListView.setAdapter(allBrandAdapter);
//                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                break;
            case R.id.fastreport_all_rank_ll:
                drawer.openDrawer(GravityCompat.END);
                VolleySingle.getInstance()._addRequest("http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/fastnewslevel-pm2-ts0.json",
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, new Response.Listener<AllRankData>() {
                            @Override
                            public void onResponse(final AllRankData response) {
                                allRankAdapter.setData(response);
                                //展开每一组
                                if (response.getResult().getList().size() > 0) {
                                    for (int i = 0; i < response.getResult().getList().size(); i++) {
                                        expandableListView.expandGroup(i);
                                    }
                                }
                                //点击不能收缩
                                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                                    @Override
                                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                        allRankTv.setText(response.getResult().getList().get(groupPosition).getLevelname());
                                        drawer.closeDrawer(GravityCompat.END);
                                        return true;
                                    }
                                });
                            }
                        }, AllRankData.class);
                expandableListView.setAdapter(allRankAdapter);
                break;
            case R.id.fastreport_drawer_close_tv:
                drawer.closeDrawer(GravityCompat.END);
//                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
        }

    }

}
