package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.UseCarData;
import com.jingjiang.thehomeofcar.inrecommend.activity.RecommendPublicAty;
import com.jingjiang.thehomeofcar.inrecommend.adapter.UseCarAdapter;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

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
        VolleySingle.getInstance()._addRequest("http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm2-c0-nt82-p1-s20-l0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<UseCarData>() {
                    @Override
                    public void onResponse(final UseCarData response) {
                        useCarAdapter.setMyRvOnClickListener(new MyRvOnClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), RecommendPublicAty.class);
                                String useCarUrl = "http://cont.app.autohome.com.cn/autov5.0.0/content/news/newscontent-n%@-t0.json";
                                useCarUrl = useCarUrl.replace("%@", String.valueOf(response.getResult().getNewslist().get(position).getId()));
                                intent.putExtra("URL", useCarUrl);
                                startActivity(intent);
                            }
                        });


                        useCarAdapter.setUseCarData(response);


                    }
                }, UseCarData.class);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);//去掉阴影部分
        recyclerView.setAdapter(useCarAdapter);

    }
}
