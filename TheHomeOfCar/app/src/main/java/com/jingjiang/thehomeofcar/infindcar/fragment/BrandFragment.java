package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ScrollView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandHotData;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandMainData;
import com.jingjiang.thehomeofcar.bean.infindcar.NewBrandData;
import com.jingjiang.thehomeofcar.infindcar.FindCarPublicActivity;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandAdapter;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandHotAdapter;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandMainAdapter;
import com.jingjiang.thehomeofcar.infindcar.inbrand.BrowserHistoryFragment;
import com.jingjiang.thehomeofcar.infindcar.inbrand.HotRankFragment;
import com.jingjiang.thehomeofcar.infindcar.inbrand.MyCollectionFragment;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

/**
 * Created by dllo on 16/5/10.
 */
public class BrandFragment extends BaseFragment implements View.OnClickListener {
    private ExpandableListView listView;
    private BrandAdapter brandAdapter;
    private BrandHotAdapter brandHotAdapter;
    private BrandMainAdapter brandMainAdapter;
    private GridView gridView, mainGridView;
    private ScrollView scrollView;
    //抽屉
    private DrawerLayout drawer;
    private FrameLayout replaceLayout;


    @Override
    public int initLayout() {
        return R.layout.findcar_f_brand;
    }
    //热销排行
    //http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/Dealer/hotsaleseries-pm2-st0.json
    //suv
    //http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/Dealer/hotsaleseries-pm2-st1.json
    //mpv
    //http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/Dealer/hotsaleseries-pm2-st2.json

    @Override
    public void initView() {
        listView = bindView(R.id.brand_listview);
        gridView = bindView(R.id.brand_gridview);
        mainGridView = bindView(R.id.brand_main_gridview);
        scrollView = bindView(R.id.brand_scrollview);
        //当进入到该页面的时候,让其从Scrollview的(0,0)位置显示
        //也就是说  顶在第一行
        scrollView.smoothScrollTo(0, 0);


        brandAdapter = new BrandAdapter(getContext());
        brandHotAdapter = new BrandHotAdapter(getContext());
        brandMainAdapter = new BrandMainAdapter(getContext());
        //去掉expandableView的标识箭头
        listView.setGroupIndicator(null);

        drawer = bindView(R.id.brand_drawer);
//        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        bindView(R.id.brand_my_collect).setOnClickListener(this);
        bindView(R.id.brand_browser_history).setOnClickListener(this);
        bindView(R.id.brand_hot_rank).setOnClickListener(this);


    }

    @Override
    public void initData() {
        //在售http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/seriesprice-pm2-b35-t1.json
        //全部http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/seriesprice-pm2-b35-t2.json
        //每一个车http://223.99.255.20/cars.app.autohome.com.cn/carinfo_v5.9.0/cars/seriessummary-pm2-s3170-t-c210200.json 奥迪
        //    http://223.99.255.20/cars.app.autohome.com.cn/carinfo_v5.9.0/cars/seriessummary-pm2-s692-t-c210200.json 奥迪a4l

        //列表
        // http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/cars/brandsdealer-pm2-ts0.json
        //http://223.99.255.20/cars.app.autohome.com.cn/cfg_v5.7.0/cars/brands-pm2-ts635966571635589297.json
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/cars.app.autohome.com.cn/cfg_v5.7.0/cars/brands-pm2-ts635966571635589297.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, new Response.Listener<NewBrandData>() {
                    @Override
                    public void onResponse(NewBrandData response) {
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

                        brandAdapter.setBrandData(response);
                    }
                }, NewBrandData.class);
//        setListViewHeight(listView);
        listView.setAdapter(brandAdapter);


        //热门品牌
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/dealer/hotbrands-pm2.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandHotData>() {
                    @Override
                    public void onResponse(BrandHotData response) {
                        brandHotAdapter.setBrandHotData(response);

                    }
                }, BrandHotData.class);
        gridView.setAdapter(brandHotAdapter);

        //主打车
        // http://223.99.255.20/adnewnc.app.autohome.com.cn/autov5.7.0/ad/infoad.ashx?version=5.9.0&platform=2&appid=2&networkid=0&adtype=1&provinceid=210000&cityid=0&lng=121.551029&lat=38.88964&gps_city=210200&pageid=6bece9fb-688c-410e-8ab5-122f6085e98e&isretry=0&deviceid=99000628573771
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/adnewnc.app.autohome.com.cn/autov5.7.0/ad/infoad.ashx?version=5.9.0&platform=2&appid=2&networkid=0&adtype=1&provinceid=210000&cityid=0&lng=121.551029&lat=38.88964&gps_city=210200&pageid=6bece9fb-688c-410e-8ab5-122f6085e98e&isretry=0&deviceid=99000628573771",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandMainData>() {
                    @Override
                    public void onResponse(final BrandMainData response) {
                        mainGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(getContext(), FindCarPublicActivity.class);
                                intent.putExtra("URL", response.getResult().getList().get(position).getJumpurl());
                                startActivity(intent);

                            }
                        });
                        brandMainAdapter.setMainData(response);

                    }
                }, BrandMainData.class);
        mainGridView.setAdapter(brandMainAdapter);

    }


    @Override
    public void onClick(View v) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.brand_my_collect:
                transaction.replace(R.id.brand_replace_fragment, new MyCollectionFragment());
                break;
            case R.id.brand_browser_history:
                transaction.replace(R.id.brand_replace_fragment, new BrowserHistoryFragment());
                break;
            case R.id.brand_hot_rank:
                transaction.replace(R.id.brand_replace_fragment, new HotRankFragment());
                break;
        }
        drawer.openDrawer(GravityCompat.END);
        transaction.commit();

    }
}
