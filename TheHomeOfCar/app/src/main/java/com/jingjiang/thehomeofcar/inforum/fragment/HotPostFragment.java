package com.jingjiang.thehomeofcar.inforum.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inforum.HotPostData;
import com.jingjiang.thehomeofcar.inforum.adapter.HotPostAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class HotPostFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private HotPostAdapter hotPostAdapter;

    @Override
    public int initLayout() {
        return R.layout.forum_f_hotpost;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.hotpost_rv);
        RecyclerViewHeader header = bindView(R.id.hotpost_header_rv);
        hotPostAdapter = new HotPostAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        header.attachTo(recyclerView);

    }

    @Override
    public void initData() {
        GsonRequest<HotPostData> hotPostDataGsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://club.app.autohome.com.cn/club_v5.6.0/club/shotfoumlist-pm1-p1-s50.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<HotPostData>() {
            @Override
            public void onResponse(HotPostData response) {
                hotPostAdapter.setHotPostData(response);
                if (BuildConfig.DEBUG)
                    Log.d("HotPostFragment", response.getResult().getList().get(0).getTitle());

            }
        }, HotPostData.class
        );
        MyRequestQueue.getRequestQueue().add(hotPostDataGsonRequest);

        recyclerView.setAdapter(hotPostAdapter);
    }
}
