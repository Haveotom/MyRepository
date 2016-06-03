package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.DepreciateData;
import com.jingjiang.thehomeofcar.bean.infindcar.DepreciateExpandData;
import com.jingjiang.thehomeofcar.infindcar.FindCarPublicActivity;
import com.jingjiang.thehomeofcar.infindcar.adapter.DepreciateAdapter;
import com.jingjiang.thehomeofcar.infindcar.indepreciate.fragment.DepreciateBrandFragment;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/10.
 */
public class DepreciateFragment extends BaseFragment implements View.OnClickListener {
    private ImageView iconIv;
    private TextView titleTv, timeTv;
    private RecyclerView recyclerView;
    private RecyclerViewHeader header;
    private DepreciateAdapter depreciateAdapter;
    private RelativeLayout headerRl;
    private DrawerLayout drawerLayout;
    private FrameLayout replace;


    @Override
    public int initLayout() {
        return R.layout.findcar_f_depreciate;
    }

    @Override
    public void initView() {
        depreciateAdapter = new DepreciateAdapter(getContext());
        iconIv = bindView(R.id.findcar_depreciate_icon_iv);
        titleTv = bindView(R.id.findcar_depreciate_title_tv);
        timeTv = bindView(R.id.findcar_depreciate_time_tv);
        recyclerView = bindView(R.id.findcar_depreciate_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //头布局
        header = bindView(R.id.findcar_depreciate_header_rv);
        //relativelayout的布局id
        headerRl = bindView(R.id.findcar_depreciate_header_rl);
        initData();

        drawerLayout = bindView(R.id.depreciate_drawer_layout);
        replace = bindView(R.id.depreciate_frame_layout);
        bindView(R.id.depreciate_brand).setOnClickListener(this);
        bindView(R.id.depreciate_price).setOnClickListener(this);
        bindView(R.id.depreciate_rank).setOnClickListener(this);
        bindView(R.id.depreciate_order).setOnClickListener(this);
        bindView(R.id.depreciate_area).setOnClickListener(this);

        bindView(R.id.depreciate_drawer_close_tv).setOnClickListener(this);


    }
    //内部  http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/dealer/pricedropfinalpage-pm2-sp%specid@-n%ariticleid@-t0-d%id@-ss%seriesid@-uid0.json
    //询底价http://223.99.255.20/cars.app.autohome.com.cn/askprice_v5.6.0/dealer/specsofdealer-pm2-d125249-ss2955.json

    @Override
    public void initData() {
        VolleySingle.getInstance()._addRequest("http://adnewnc.app.autohome.com.cn/autov5.7.0/ad/getadinfo.ashx?appid=2&platform=2&version=5.8.5&advertype=23&series=0&networkid=0&idfa=0&deviceid=99000628573771&mac=02%3A00%3A00%3A00%3A00%3A00&cityid=210200&devicebrand=Xiaomi&devicemodel=MI4LTE&lng=121.550923&lat=38.88966&gps_city=210200&pageid=0898c0ec-e7bd-42b3-a141-fa67bb04d023&isretry=0",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<DepreciateExpandData>() {
                    @Override
                    public void onResponse(final DepreciateExpandData response) {
                        Picasso.with(getContext()).load(response.getResult().getImgpath()).resize(140, 100)
                                .into(iconIv);
                        titleTv.setText(response.getResult().getTitle());
                        timeTv.setText(response.getResult().getPubtime());
                        //点击该布局
                        headerRl.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(), FindCarPublicActivity.class);
                                intent.putExtra("URL", response.getResult().getUrl());
                                startActivity(intent);
                            }
                        });
                    }
                }, DepreciateExpandData.class);

        VolleySingle.getInstance()._addRequest("http://cars.app.autohome.com.cn/dealer_v5.7.0/dealer/pdspecs-pm2-pi210000-c210200-o0-b0-ss0-sp0-p1-s20-l0-minp0-maxp0-lon121.550923-lat38.88966.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<DepreciateData>() {
                    @Override
                    public void onResponse(DepreciateData response) {
                        depreciateAdapter.setDepreciateData(response);

                    }
                }, DepreciateData.class);

        //添加头布局
        //注意一定要在加了RecyclerView的数据之后
        //才可以加头布局
        //否则会有错
        header.attachTo(recyclerView);
        recyclerView.setAdapter(depreciateAdapter);


    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.depreciate_brand:
                drawerLayout.openDrawer(GravityCompat.END);
                transaction.replace(R.id.depreciate_frame_layout, new DepreciateBrandFragment());
                break;
            case R.id.depreciate_price:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.depreciate_rank:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.depreciate_order:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.depreciate_area:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.depreciate_drawer_close_tv:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
        transaction.commit();

    }
}
