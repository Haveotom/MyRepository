package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewestData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;
import com.youth.banner.Banner;


/**
 * Created by dllo on 16/5/9.
 */
public class NewestFragment extends BaseFragment {
    private NewestAdapter newestAdapter;
    private RecyclerView recyclerView;
    //刷新
    private SwipeRefreshLayout refresh;
    private RecyclerViewHeader header;
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
        header = bindView(R.id.newest_header_rv);
//        refresh = bindView(R.id.newest_refresh);
//        refresh.setOnRefreshListener(this);
        newestAdapter = new NewestAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        banner = bindView(R.id.newest_recycle_picture);
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
                                if (data.getResult().getFocusimg().get(position-1).getJumpurl() != "") {
                                    intent.putExtra("URL", data.getResult().getFocusimg().get(position-1).getJumpurl());
                                    startActivity(intent);
                                } else if (data.getResult().getFocusimg().get(position-1).getJumpurl() == "") {

                                    if (data.getResult().getFocusimg().get(position-1).getMediatype() == 1) {
                                        recycleUrl = "http://cont.app.autohome.com.cn/autov5.0.0/content/news/newscontent-n%@-t0.json";

                                    } else if (data.getResult().getFocusimg().get(position-1).getMediatype() == 2) {
                                        recycleUrl = "http://v.autohome.com.cn/v_4_%@.html";
                                    } else {
                                        recycleUrl = "http://forum.app.autohome.com.cn/autov5.0.0/forum/club/topiccontent-a2-pm2-v5.0.0-t%@-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw320.json";
                                    }
                                    recycleUrl = recycleUrl.replace("%@", String.valueOf(data.getResult().getFocusimg().get(position-1).getId()));
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
        header.attachTo(recyclerView);
        recyclerView.setAdapter(newestAdapter);
    }

}
