package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.infindcar.adapter.BrandAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/10.
 */
public class BrandFragment extends BaseFragment {
    private ListView listView;
    private BrandAdapter brandAdapter;
    private ImageView dazhong, bentian, fengtian, xiandai, bieke, fute, aodi, jili, hafu, richan;

    @Override
    public int initLayout() {
        return R.layout.findcar_f_brand;
    }

    @Override
    public void initView() {
        listView = bindView(R.id.brand_listview);
        brandAdapter = new BrandAdapter(getContext());
        dazhong = bindView(R.id.brand_dazhong);
        bentian = bindView(R.id.brand_bentian);
        fengtian = bindView(R.id.brand_fengtian);
        xiandai = bindView(R.id.brand_xiandai);
        bieke = bindView(R.id.brand_bieke);
        fute = bindView(R.id.brand_aodi);
        aodi = bindView(R.id.brand_aodi);
        jili = bindView(R.id.brand_jili);
        hafu = bindView(R.id.brand_richan);


    }

    @Override
    public void initData() {

        GsonRequest<BrandData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov5.0.0/news/brandsfastnews-pm1-ts0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<BrandData>() {
            @Override
            public void onResponse(BrandData response) {
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(0).getList().get(0).getImgurl().replace("~","")).
//                        into(aodi);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(1).getList().get(1).getImgurl().replace("~","")).
//                        into(bentian);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(3).getList().get(0).getImgurl().replace("~","")).
//                        into(dazhong);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(5).getList().get(0).getImgurl().replace("~","")).
//                        into(fengtian);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(20).getList().get(0).getImgurl().replace("~","")).
//                        into(xiandai);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(1).getList().get(6).getImgurl().replace("~","")).
//                        into(bieke);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(5).getList().get(1).getImgurl().replace("~","")).
//                        into(fute);
////                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
////                        response.getResult().getBrandlist().get(5).getList().get(1).getImgurl().replace("~","")).
////                        into(richan);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(7).getList().get(1).getImgurl().replace("~","")).
//                        into(hafu);
//                Picasso.with(getContext()).load("http://car2.autoimg.cn"+
//                        response.getResult().getBrandlist().get(9).getList().get(0).getImgurl().replace("~","")).
//                        into(jili);
                if (BuildConfig.DEBUG)
                    Log.d("BrandFragment", response.getResult().getBrandlist().get(0).getList().get(0).getImgurl());
                brandAdapter.setBrandData(response);

            }
        }, BrandData.class);


        MyRequestQueue.getRequestQueue().add(gsonRequest);
        listView.setAdapter(brandAdapter);


    }

    ///http://www2.autoimg.cn/logo/brand/50/129302877535937500.jpg
    //~/cardfs/brand/50/g16/M05/5B/78/autohomecar__wKgH11cVh1WADo76AAAK8dMrElU714.jpg
    // http://app.api.autohome.com.cn/autov5.0.0/news/brandsfastnews-pm1-ts0.json
    //http://car2.autoimg.cn/cardfs/product/g8/M0F/72/19/s_autohomecar__wKjBz1cy_SaAWhoaAAkLW9ousmE052.jpg
    //http://car2.autoimg.cn/cardfs/brand/50/g16/M05/5B/78/autohomecar__wKgH11cVh1WADo76AAAK8dMrElU714.jpg
}
