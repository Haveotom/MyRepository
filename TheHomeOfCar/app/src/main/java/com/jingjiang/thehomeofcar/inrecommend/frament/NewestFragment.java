package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewestData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/5/9.
 */
public class NewestFragment extends BaseFragment {
    private NewestAdapter newestAdapter;
    private RecyclerView recyclerView;


    @Override
    public int initLayout() {
        return R.layout.recommend_f_newest;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.newest_rv);
        RecyclerViewHeader header = bindView(R.id.newest_header_rv);
        newestAdapter = new NewestAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        header.attachTo(recyclerView);

    }

    @Override
    public void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<NewestData> newestDataGsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov4.2.5/news/newslist-a2-pm1-v4.2.5-c0-nt0-p1-s30-l0.html",
                new Response.ErrorListener() {//失败
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewestData>() {//成功

            @Override
            public void onResponse(NewestData response) {
//                if (BuildConfig.DEBUG)
//                    Log.d("NewestFragment", response.getResult().getNewslist().get(2).getTitle());
                newestAdapter.setNewestData(response);
            }
        }, NewestData.class);
        requestQueue.add(newestDataGsonRequest);

        recyclerView.setAdapter(newestAdapter);
    }
}
