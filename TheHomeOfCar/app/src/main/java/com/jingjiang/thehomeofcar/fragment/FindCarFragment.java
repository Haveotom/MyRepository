package com.jingjiang.thehomeofcar.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.adapter.FindCarAdapter;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.BrandFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.DepreciateFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.FilterFragment;
import com.jingjiang.thehomeofcar.infindcar.fragment.SecondCarFragment;

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
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new BrandFragment());
        fragments.add(new DepreciateFragment());
        fragments.add(new FilterFragment());
        fragments.add(new SecondCarFragment());
    }

    @Override
    public void initData() {

    }
}
