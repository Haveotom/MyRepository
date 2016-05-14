package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.FastReportData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.FastReportAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class FastReportFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private FastReportAdapter fastReportAdapter;


    @Override
    public int initLayout() {
        return R.layout.recommend_f_fastreport;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.fastreport_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fastReportAdapter = new FastReportAdapter(getContext());

    }

    @Override
    public void initData() {

        GsonRequest<FastReportData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov5.0.0/news/fastnewslist-pm2-b0-l0-s20-lastid0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<FastReportData>() {
            @Override
            public void onResponse(FastReportData response) {
                Log.d("FastReportFragment", "response.getResult().getList().get(0).getReviewcount():" + response.getResult().getList().get(0).getTitle());

                fastReportAdapter.setFastReportDatas(response);

            }
        }, FastReportData.class);
        MyRequestQueue.getRequestQueue().add(gsonRequest);

        recyclerView.setAdapter(fastReportAdapter);
    }
}
