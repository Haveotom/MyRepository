package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.infindcar.FilterData;
import com.jingjiang.thehomeofcar.infindcar.adapter.FilterAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;
import com.jingjiang.thehomeofcar.widget.VolleySingle;

import org.w3c.dom.Text;

/**
 * Created by dllo on 16/5/10.
 * http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/gethotseries-a2-pm2-v5.8.5-p1-s20.json
 * 每一个 http://183.232.160.141/cars.app.autohome.com.cn/carinfo_v5.9.0/cars/seriessummary-pm2-s%@-t-c210200.json
 * 推荐车系http://183.232.160.141/cars.app.autohome.com.cn/cars_v5.7.0/cars/seriesattentionseries.ashx?appid=2&seriesid=%@
 */
public class FilterFragment extends BaseFragment {
    private ListView listView;
    private FilterAdapter filterAdapter;
    private LinearLayout factorLl;
    private PopupWindow popupWindow;
    private TextView textView;

    @Override
    public int initLayout() {
        return R.layout.findcar_f_filter;
    }

    @Override
    public void initView() {
        listView = bindView(R.id.filter_listview);
        filterAdapter = new FilterAdapter(getContext());
        VolleySingle.getInstance()._addRequest("http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/gethotseries-a2-pm2-v5.8.5-p1-s20.json",
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
        listView.setAdapter(filterAdapter);

        textView = bindView(R.id.filter_text_view_tv);
        factorLl = bindView(R.id.filter_popup_window_ll);
        factorLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    textView.setTextColor(getResources().getColor(R.color.grayWord));
                    params.alpha = 1f;
                    getActivity().getWindow().setAttributes(params);
                } else {
                    popupWindow.showAsDropDown(factorLl);//显示在factorLl下面
                    textView.setTextColor(getResources().getColor(R.color.blue));
                    params.alpha = 0.5f;
                    getActivity().getWindow().setAttributes(params);
                }


            }
        });


    }

    @Override
    public void initData() {
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT,
                900);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.findcar_f_filter_popupwindow, null);
        popupWindow.setContentView(view);
        //可以确定他在某个组件的下面弹出
//        popupWindow.showAsDropDown(button,0,100);

    }
}
