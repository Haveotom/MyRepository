package com.jingjiang.thehomeofcar.infindcar.indepreciate.fragment;

import android.view.View;
import android.widget.ExpandableListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.infindcar.indepreciate.adapter.DepreciateBrandAdapter;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

/**
 * Created by dllo on 16/6/2.
 */
public class DepreciateBrandFragment extends BaseFragment {
    private ExpandableListView expandableListView;
    private DepreciateBrandAdapter adapter;


    @Override
    public int initLayout() {
        return R.layout.depreciate_f_brand;
    }

    @Override
    public void initView() {
        expandableListView = bindView(R.id.depreciate_expandable_lv);
        adapter = new DepreciateBrandAdapter(getContext());
        expandableListView.setGroupIndicator(null);

    }

    @Override
    public void initData() {
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/news.app.autohome.com.cn/fastnews_v5.6.0/news/brandsfastnews-pm2-ts0.json",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, new Response.Listener<BrandData>() {
                    @Override
                    public void onResponse(BrandData response) {
                        if (response.getResult().getBrandlist().size() > 0) {
                            for (int i = 0; i < response.getResult().getBrandlist().size(); i++) {
                                expandableListView.expandGroup(i);//展开
                            }
                        }
                        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                            @Override
                            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                return true;
                            }
                        });
                        adapter.setData(response);

                    }
                }, BrandData.class);
        expandableListView.setAdapter(adapter);

    }


}
