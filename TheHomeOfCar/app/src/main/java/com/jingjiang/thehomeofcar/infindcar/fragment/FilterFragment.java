package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.FilterData;
import com.jingjiang.thehomeofcar.infindcar.adapter.FilterAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

/**
 * Created by dllo on 16/5/10.
 * http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/gethotseries-a2-pm2-v5.8.5-p1-s20.json
 */
public class FilterFragment extends BaseFragment {
    private ListView listView;
    private FilterAdapter filterAdapter;

    @Override
    public int initLayout() {
        return R.layout.findcar_f_filter;
    }

    @Override
    public void initView() {
        listView = bindView(R.id.filter_listview);
        filterAdapter = new FilterAdapter(getContext());

        GsonRequest<FilterData> gsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/gethotseries-a2-pm2-v5.8.5-p1-s20.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<FilterData>() {
            @Override
            public void onResponse(FilterData response) {
                filterAdapter.setFilterData(response);

            }
        }, FilterData.class);
        MyRequestQueue.getRequestQueue().add(gsonRequest);
        listView.setAdapter(filterAdapter);

    }

    @Override
    public void initData() {

    }
}
