package com.jingjiang.thehomeofcar.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.indiscover.ActivityAreaData;
import com.jingjiang.thehomeofcar.bean.indiscover.HotSellData;
import com.jingjiang.thehomeofcar.indiscover.adapter.ActivityAreaAdapter;
import com.jingjiang.thehomeofcar.indiscover.adapter.BrandBoutiqueAdapter;
import com.jingjiang.thehomeofcar.indiscover.adapter.BrandListAdapter;
import com.jingjiang.thehomeofcar.indiscover.adapter.CarBusinessAdapter;
import com.jingjiang.thehomeofcar.indiscover.adapter.CarMediaAdapter;
import com.jingjiang.thehomeofcar.indiscover.adapter.HotSellAdapter;
import com.jingjiang.thehomeofcar.indiscover.activity.PublicActivity;
import com.jingjiang.thehomeofcar.searchui.SearchActivity;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

/**
 * Created by dllo on 16/5/9.
 */
public class DiscoverFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private CarMediaAdapter carMediaAdapter;
    private GridView gridView, carBusinessGridView, hotSellGridView, brandGridView;
    private ActivityAreaAdapter activityAreaAdapter;
    private CarBusinessAdapter carBusinessAdapter;
    private HotSellAdapter hotSellAdapter;
    private BrandBoutiqueAdapter brandBoutiqueAdapter;
    private ListView listView;//商品列表
    private BrandListAdapter brandListAdapter;


    @Override
    public int initLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    public void initView() {
        bindView(R.id.discover_search_iv).setOnClickListener(this);
        //汽车音频
        recyclerView = bindView(R.id.discover_car_media_rv);//汽车音频行
        LinearLayoutManager horizentalManager = new LinearLayoutManager(getContext());
        horizentalManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(horizentalManager);//设置水平
        carMediaAdapter = new CarMediaAdapter(getContext());
        //活动专区
        gridView = bindView(R.id.discover_activity_area_gv);
        activityAreaAdapter = new ActivityAreaAdapter(getContext());
        //车商城
        carBusinessGridView = bindView(R.id.discover_car_business_gv);
        carBusinessAdapter = new CarBusinessAdapter();
        //特惠热卖
        hotSellGridView = bindView(R.id.discover_hot_sell_gv);
        hotSellAdapter = new HotSellAdapter();
        //品牌精品
        brandGridView = bindView(R.id.discover_hot_sell_brand_gv);
        brandBoutiqueAdapter = new BrandBoutiqueAdapter();
        //商品列表
        listView = bindView(R.id.discover_lv);
        brandListAdapter = new BrandListAdapter();
        //监听事件


    }

    @Override
    public void initData() {
        final Intent intent = new Intent(MyApplication.context, PublicActivity.class);
        //汽车音频行
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/mobilenc.app.autohome.com.cn/discover_v5.8.0/mobile/functionlist-a2-pm2-v5.8.5-pid210000-cid210200.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<ActivityAreaData>() {
                    @Override
                    public void onResponse(final ActivityAreaData response) {
                        carMediaAdapter.setActivityAreaData(response);
                        activityAreaAdapter.setActivityAreaData(response);
                        carBusinessAdapter.setActivityAreaData(response);
                        //汽车音频
                        carMediaAdapter.setOnItemClickListener(new CarMediaAdapter.ItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                if (response.getResult().getFunctionlist().get(position).getUrl() != null) {
                                    String carMediaUrl = response.getResult().getFunctionlist().get(position).getUrl();
                                    intent.putExtra("carMediaUrl", carMediaUrl);
                                    startActivity(intent);
                                }

                            }
                        });

                        //活动专区监听事件
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String url = response.getResult().getImageads().getImageadsinfo().get(position).getUrl();
                                intent.putExtra("activityUrl", url);
                                startActivity(intent);
                            }
                        });
                        //车商城 监听事件
                        carBusinessGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                Intent intent = new Intent(MyApplication.context, PublicActivity.class);
                                String url = response.getResult().getBusinesslist().get(position).getUrl();
                                String title = response.getResult().getBusinesslist().get(position).getTitle();
                                intent.putExtra("title", title);
                                intent.putExtra("url", url);
                                startActivity(intent);
                            }
                        });


                    }
                }, ActivityAreaData.class);

        recyclerView.setAdapter(carMediaAdapter);
        gridView.setAdapter(activityAreaAdapter);
        carBusinessGridView.setAdapter(carBusinessAdapter);

        //特惠热卖
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/mobilenc.app.autohome.com.cn/discover_v5.8.0/mall/intelligentrecommend.ashx?a=2&pm=2&v=5.8.5&uid=0&deviceid=99000628573771&gps=38.889659,121.551063&cityid=210200&pid=210000&pageindex=1&pagesize=20&hid=",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<HotSellData>() {
                    @Override
                    public void onResponse(final HotSellData response) {
                        hotSellAdapter.setHotSellData(response);
                        brandBoutiqueAdapter.setHotSellData(response);
                        brandListAdapter.setHotSellData(response);
                        //特惠热卖
                        hotSellGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String hotSellUrl = response.getResult().getModulelist().get(0).getList().get(position).getMurl();
                                intent.putExtra("hostSellUrl", hotSellUrl);
                                startActivity(intent);

                            }
                        });
                        //品牌精品
                        brandGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String hotSellUrl = response.getResult().getModulelist().get(1).getList().get(position).getMurl();
                                intent.putExtra("brandUrl", hotSellUrl);
                                startActivity(intent);

                            }
                        });
                        //商品了列表
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String brandListUrl = response.getResult().getGoodslist().getList().get(position).getMurl();
                                intent.putExtra("brandListUrl", brandListUrl);
                                startActivity(intent);
                            }
                        });


                    }
                }, HotSellData.class);
        hotSellGridView.setAdapter(hotSellAdapter);
        brandGridView.setAdapter(brandBoutiqueAdapter);
        listView.setAdapter(brandListAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discover_search_iv:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
        }
    }
}
