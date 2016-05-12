package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.VideoData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.VideoAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class VideoFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;

    @Override
    public int initLayout() {
        return R.layout.recommend_f_video;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.video_rv);
        videoAdapter = new VideoAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    @Override
    public void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<VideoData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov5.0.0/news/videolist-pm2-vt0-s20-lastid0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<VideoData>() {
            @Override
            public void onResponse(VideoData response) {
                videoAdapter.setVideoData(response);

            }
        }, VideoData.class);
        requestQueue.add(gsonRequest);


        recyclerView.setAdapter(videoAdapter);
    }
}
