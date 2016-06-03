package com.jingjiang.thehomeofcar.inforum.fragment;


import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.AreaData;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.inforum.inuseforum.adapter.AreaAdapter;
import com.jingjiang.thehomeofcar.inforum.inuseforum.adapter.CarAdapter;
import com.jingjiang.thehomeofcar.inforum.inuseforum.adapter.FlagTopicAdapter;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 * 车系论坛
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b3667-btc-r1-ss0-o0-p1-s50-qf0-c210200.json 精华帖
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b3667-btc-r0-ss0-o2-p1-s50-qf0-c210200.json 最新发布
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b3667-btc-r0-ss0-o0-p1-s50-qf0-c210200.json 最后回复
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b3667-btc-r0-ss0-o0-p1-s50-qf1-c210200.json 质量反馈
 * 地区论坛
 * http://clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b100001-bta-r0-ss0-o0-p1-s50-qf0-c210200.json 自最后
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b100001-bta-r0-ss0-o2-p1-s50-qf0-c210200.json 最新
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b100001-bta-r1-ss0-o0-p1-s50-qf0-c210200.json 精华
 * <p/>
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b200009-bto-r0-ss0-o0-p1-s50-qf0-c210200.json 最后回复
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b200009-bto-r0-ss0-o2-p1-s50-qf0-c210200.json
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b200009-bto-r0-ss0-o2-p1-s50-qf0-c210200.json 最新发布
 * http://223.99.255.20/clubnc.app.autohome.com.cn/club_v5.6.0/club/topics-pm2-b200009-bto-r1-ss0-o0-p1-s50-qf0-c210200.json 精华帖
 */
public class UseForumFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout carLl, areaLl, flagTopicLl;
    private DrawerLayout drawer;
    private ExpandableListView listView;
    private CarAdapter carAdapter;
    private AreaAdapter areaAdapter;
    private FlagTopicAdapter flagTopicAdapter;
    private TextView titleTv, closeTv;
    private List<String> letter = new ArrayList<>();
    private List<String> forum = new ArrayList<>();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public int initLayout() {
        return R.layout.forum_f_useforum;
    }

    @Override
    public void initView() {
        carAdapter = new CarAdapter(getContext());
        areaAdapter = new AreaAdapter(getContext());
        flagTopicAdapter = new FlagTopicAdapter(getContext());

        titleTv = bindView(R.id.drawer_car_tv);
        closeTv = bindView(R.id.drawer_close_tv);
        //三个选择
        carLl = bindView(R.id.useforum_car_rl);
        areaLl = bindView(R.id.useforum_area_rl);
        flagTopicLl = bindView(R.id.useforum_flagtopic_rl);
        //抽屉
        drawer = bindView(R.id.drawer_layout);
//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//关闭手势滑动
        //listview
        listView = bindView(R.id.useforum_expandable_lv);
        listView.setGroupIndicator(null);
        listView.smoothScrollToPositionFromTop(0, 0);
        carLl.setOnClickListener(this);
        areaLl.setOnClickListener(this);
        flagTopicLl.setOnClickListener(this);
        closeTv.setOnClickListener(this);


    }


    @Override
    public void initData() {
        for (char i = 'A'; i <= 'Z'; i++) {
            letter.add(i + "");
        }
        areaAdapter.setLetter(letter);
        //主题论坛
        forum.add("精彩作业论坛");
        forum.add("维修保养论坛");
        forum.add("装饰改装论坛");
        forum.add("自驾游论坛");
        forum.add("摄影论坛");
        forum.add("车展快报论坛");
        forum.add("社区公告论坛");
        forum.add("养车之家论坛");
        forum.add("经销商论坛");
        forum.add("自行车论坛");
        forum.add("GPS论坛");
        forum.add("App应用论坛");
        forum.add("摩托车论坛");
        forum.add("卡丁车论坛");
        forum.add("活动报道论坛");

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.useforum_car_rl:
                titleTv.setText("车系论坛");
                //车系论坛
                //http://223.99.255.20/club.app.autohome.com.cn/club_v5.6.0/club/clubsseries-pm2-st636003578376406030.json
                VolleySingle.getInstance()._addRequest("http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/cars/brandsdealer-pm2-ts0.json",
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, new Response.Listener<BrandData>() {
                            @Override
                            public void onResponse(BrandData response) {
                                //首次加载默认父item展开
                                if (response.getResult().getBrandlist().size() > 0) {
                                    for (int i = 0; i < response.getResult().getBrandlist().size(); i++) {
                                        listView.expandGroup(i);
                                    }
                                }
                                //父item不能点击收缩
                                listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                                    @Override
                                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                        return true;
                                    }
                                });
                                carAdapter.setData(response);

                            }
                        }, BrandData.class);
                listView.setAdapter(carAdapter);
                drawer.openDrawer(GravityCompat.END);
                break;
            case R.id.useforum_area_rl:
                titleTv.setText("地区论坛");
                VolleySingle.getInstance()._addRequest("http://comm.app.autohome.com.cn/news/province-pm2-ts0.json",
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, new Response.Listener<AreaData>() {
                            @Override
                            public void onResponse(AreaData response) {
                                //首次加载默认父item展开
                                if (response.getResult().getProvinces().size() > 0) {
                                    for (int i = 0; i < response.getResult().getProvinces().size(); i++) {
                                        listView.expandGroup(i);
                                    }
                                }
                                //父item不能点击收缩
                                listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                                    @Override
                                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                        return true;
                                    }
                                });
                                areaAdapter.setAreaData(response);
                            }
                        }, AreaData.class);
                listView.setAdapter(areaAdapter);
                drawer.openDrawer(GravityCompat.END);
                break;
            case R.id.useforum_flagtopic_rl:
                flagTopicAdapter.setForum(forum);
                listView.setAdapter(flagTopicAdapter);
                drawer.openDrawer(GravityCompat.END);

                break;
            case R.id.drawer_close_tv:
                drawer.closeDrawer(GravityCompat.END);
                break;
        }

    }
}
