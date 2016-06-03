package com.jingjiang.thehomeofcar.inrecommend.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.FastReportDetailData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.FastReportAdapter;
import com.jingjiang.thehomeofcar.inrecommend.adapter.FastReportDetailAdapter;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * Created by dllo on 16/5/24.
 */
public class FastReportAty extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerViewHeader header;
    private TextView titleTv, authorTv, countTv, newstypenameTv;
    private ImageView exitIv, pictureIv;
    private FastReportDetailAdapter fastReportDetailAdapter;

    @Override
    protected int getLayout() {
        return R.layout.aty_fastreport_detail;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.fastreport_detail_rv);
        header = bindView(R.id.fastreport_detail_header_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        titleTv = bindView(R.id.fastreport_detail_title);
        authorTv = bindView(R.id.fastreport_detail_author);
        countTv = bindView(R.id.fastreport_detail_count);
        pictureIv = bindView(R.id.fastreport_detail_picture);
        newstypenameTv = bindView(R.id.fastreport_detail_newstypename);
        fastReportDetailAdapter = new FastReportDetailAdapter(MyApplication.context);
        int id = getIntent().getIntExtra("ID", 0);
        //拼接id
        String url = "http://cont.app.autohome.com.cn/autov5.0.0/content/News/fastnewscontent-n" + id + "-lastid0-o1.json";
        VolleySingle.getInstance()._addRequest(url, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("FastReportAty", "你好");

            }
        }, new Response.Listener<FastReportDetailData>() {
            @Override
            public void onResponse(FastReportDetailData response) {
                titleTv.setText(response.getResult().getNewsdata().getTitle());
                authorTv.setText(response.getResult().getNewsdata().getNewsauthor());
                countTv.setText(response.getResult().getNewsdata().getReviewcount() + "人浏览");
                newstypenameTv.setText(response.getResult().getNewsdata().getNewstypeanme());
                Picasso.with(MyApplication.context).load(response.getResult().getNewsdata().getImg()).
                        error(R.mipmap.car).into(pictureIv);
                fastReportDetailAdapter.setDetailData(response);


            }
        }, FastReportDetailData.class);
        //添加头布局
        header.attachTo(recyclerView);
        recyclerView.setAdapter(fastReportDetailAdapter);

        bindView(R.id.fastreport__detail_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {


    }
}




