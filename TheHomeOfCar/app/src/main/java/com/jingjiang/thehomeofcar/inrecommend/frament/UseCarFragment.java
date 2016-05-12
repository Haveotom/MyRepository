package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.UseCarData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.UseCarAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;

/**
 * Created by dllo on 16/5/9.
 */
public class UseCarFragment extends BaseFragment {
    private UseCarAdapter useCarAdapter;
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.recommend_f_usecar;
    }

    @Override
    public void initView() {
        useCarAdapter = new UseCarAdapter(getContext());
        recyclerView = bindView(R.id.usecar_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<UseCarData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm2-c0-nt82-p1-s20-l0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<UseCarData>() {
            @Override
            public void onResponse(UseCarData response) {
                useCarAdapter.setUseCarData(response);

            }
        }, UseCarData.class);
        requestQueue.add(gsonRequest);
        recyclerView.setAdapter(useCarAdapter);

    }
}
