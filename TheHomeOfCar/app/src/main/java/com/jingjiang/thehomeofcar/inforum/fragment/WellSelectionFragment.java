package com.jingjiang.thehomeofcar.inforum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inforum.WellSelectionData;
import com.jingjiang.thehomeofcar.inforum.ForumPublicActivity;
import com.jingjiang.thehomeofcar.inforum.adapter.WellSelectionAdapter;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class WellSelectionFragment extends BaseFragment {
    private WellSelectionAdapter wellSelectionAdapter;
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.forum_f_wellselection;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.wellselection_rv);
        wellSelectionAdapter = new WellSelectionAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    //http://clubnc.app.autohome.com.cn/club_v5.6.0/club/jingxuantopic.ashx?platud=2&categoryid=0&pageindex=1&pagesize=30&devicetype=android.MI+4LTE&deviceid=99000628573771&userid=0&operation=1&netstate=0&gps=38.889623%2C121.551014
    //http://clubnc.app.autohome.com.cn/club_v5.6.0/club/jingxuantopic.ashx?platud=2&categoryid=104&pageindex=1&pagesize=30&devicetype=android.MI+4LTE&deviceid=99000628573771&userid=0&operation=1&netstate=0&gps=38.889644,121.550961
    @Override
    public void initData() {
        VolleySingle.getInstance()._addRequest("http://clubnc.app.autohome.com.cn/club_v5.6.0/club/jingxuantopic.ashx?platud=2&categoryid=0&pageindex=1&pagesize=30&devicetype=android.MI+4LTE&deviceid=99000628573771&userid=0&operation=1&netstate=0&gps=38.889623%2C121.551014",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<WellSelectionData>() {
                    @Override
                    public void onResponse(final WellSelectionData response) {
                        wellSelectionAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), ForumPublicActivity.class);
                                int id = response.getResult().getList().get(position).getTopicid();
                                intent.putExtra("ID", id);
                                startActivity(intent);
                            }
                        });
                        wellSelectionAdapter.setWellSelectionData(response);
                    }
                }, WellSelectionData.class);

        recyclerView.setAdapter(wellSelectionAdapter);
    }
}
