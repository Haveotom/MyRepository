package com.jingjiang.thehomeofcar.inforum.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inforum.HotPostData;
import com.jingjiang.thehomeofcar.inforum.ForumPublicActivity;
import com.jingjiang.thehomeofcar.inforum.adapter.HotPostAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

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
        VolleySingle.getInstance()._addRequest("http://club.app.autohome.com.cn/club_v5.6.0/club/shotfoumlist-pm1-p1-s50.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<HotPostData>() {
                    @Override
                    public void onResponse(final HotPostData response) {
                        hotPostAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), ForumPublicActivity.class);
                                int id = response.getResult().getList().get(position).getTopicid();
                                intent.putExtra("ID", id);
                                startActivity(intent);
                            }
                        });
                        hotPostAdapter.setHotPostData(response);

                    }
                }, HotPostData.class);
        recyclerView.setAdapter(hotPostAdapter);
    }
}
