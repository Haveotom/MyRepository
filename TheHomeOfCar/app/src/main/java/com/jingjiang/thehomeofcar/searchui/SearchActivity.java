package com.jingjiang.thehomeofcar.searchui;

import android.widget.SearchView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;

/**
 * Created by dllo on 16/5/15.
 *
 * 搜索页的布局Activity
 */
public class SearchActivity extends BaseActivity {
    private SearchView searchView;

    @Override
    protected int getLayout() {
        return R.layout.search_ui;
    }

    @Override
    protected void initView() {
        searchView = bindView(R.id.search_frame);

    }

    @Override
    protected void initData() {

    }
}
