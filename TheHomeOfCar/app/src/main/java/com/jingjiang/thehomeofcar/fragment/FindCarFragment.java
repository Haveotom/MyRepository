package com.jingjiang.thehomeofcar.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.adapter.FindCarAdapter;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.BrandFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.DepreciateFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.FilterFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.SecondCarFragment;
import com.jingjiang.thehomeofcar.searchui.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class FindCarFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FindCarAdapter findCarAdapter;
    private List<Fragment> fragments;
    private ImageView searchIv;

    @Override
    public int initLayout() {
        return R.layout.fragment_findcar;
    }

    @Override
    public void initView() {
        tabLayout = bindView(R.id.findcar_tablayout);
        viewPager = bindView(R.id.findcar_viewpager);
        initFragment();
        findCarAdapter = new FindCarAdapter(getChildFragmentManager());
        findCarAdapter.setFragments(fragments);
        viewPager.setAdapter(findCarAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY, Color.rgb(0, 180, 255));
        tabLayout.setSelectedTabIndicatorColor(Color.rgb(0, 180, 255));
        searchIv = bindView(R.id.findcar_search);
        searchIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SearchActivity.class);
                startActivity(intent);

            }
        });
        //当页面发生变化时的监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {//position就是当前页面viewPager选中的页面
                setTitleBar(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

    }

    private void setTitleBar(int pos) {
        switch (pos) {
            case 0:
                searchIv.setVisibility(View.VISIBLE);
                break;
            case 1:
                searchIv.setVisibility(View.VISIBLE);
                break;
            case 2:
                searchIv.setVisibility(View.INVISIBLE);

            case 3:

                break;
        }

    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new BrandFragment());
        fragments.add(new FilterFragment());
        fragments.add(new DepreciateFragment());
        fragments.add(new SecondCarFragment());
    }

    @Override
    public void initData() {

    }
}
