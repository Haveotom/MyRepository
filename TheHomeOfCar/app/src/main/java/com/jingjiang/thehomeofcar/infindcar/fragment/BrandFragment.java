package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandHotData;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandMainData;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandAdapter;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandHotAdapter;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandMainAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/10.
 */
public class BrandFragment extends BaseFragment {
    private ListView listView;
    private BrandAdapter brandAdapter;
    private BrandHotAdapter brandHotAdapter;
    private BrandMainAdapter brandMainAdapter;
    private GridView gridView, mainGridView;

    @Override
    public int initLayout() {
        return R.layout.findcar_f_brand;
    }

    @Override
    public void initView() {
        listView = bindView(R.id.brand_listview);
        gridView = bindView(R.id.brand_gridview);
        mainGridView = bindView(R.id.brand_main_gridview);

        brandAdapter = new BrandAdapter(getContext());
        brandHotAdapter = new BrandHotAdapter(getContext());
        brandMainAdapter = new BrandMainAdapter(getContext());


    }

    @Override
    public void initData() {

        VolleySingle.getInstance()._addRequest("http://app.api.autohome.com.cn/autov5.0.0/news/brandsfastnews-pm1-ts0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandData>() {
                    @Override
                    public void onResponse(BrandData response) {
                        if (BuildConfig.DEBUG)
                            Log.d("BrandFragment", response.getResult().getBrandlist().get(0).getList().get(0).getImgurl());
                        brandAdapter.setBrandData(response);

                    }
                }, BrandData.class);
        listView.setAdapter(brandAdapter);

        VolleySingle.getInstance()._addRequest( "http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/dealer/hotbrands-pm2.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandHotData>() {
                    @Override
                    public void onResponse(BrandHotData response) {
                        brandHotAdapter.setBrandHotData(response);
                        if (BuildConfig.DEBUG)
                            Log.d("BrandFragment", response.getResult().getList().get(0).getName());


                    }
                }, BrandHotData.class);
        gridView.setAdapter(brandHotAdapter);

        VolleySingle.getInstance()._addRequest( "http://223.99.255.20/adnewnc.app.autohome.com.cn/autov5.7.0/ad/infoad.ashx?version=5.8.5&platform=2&appid=2&networkid=0&adtype=1&provinceid=210000&cityid=0&lng=121.551079&lat=38.889656&gps_city=210200&pageid=04704225-c34a-425c-8e4b-f8781eaf19dd&isretry=1&deviceid=99000628573771",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandMainData>() {
                    @Override
                    public void onResponse(BrandMainData response) {
                        brandMainAdapter.setMainData(response);

                    }
                }, BrandMainData.class);
        mainGridView.setAdapter(brandMainAdapter);


    }

    ///http://www2.autoimg.cn/logo/brand/50/129302877535937500.jpg
    //~/cardfs/brand/50/g16/M05/5B/78/autohomecar__wKgH11cVh1WADo76AAAK8dMrElU714.jpg
    // http://app.api.autohome.com.cn/autov5.0.0/news/brandsfastnews-pm1-ts0.json
    //http://car2.autoimg.cn/cardfs/product/g8/M0F/72/19/s_autohomecar__wKjBz1cy_SaAWhoaAAkLW9ousmE052.jpg
    //http://car2.autoimg.cn/cardfs/brand/50/g16/M05/5B/78/autohomecar__wKgH11cVh1WADo76AAAK8dMrElU714.jpg
}
