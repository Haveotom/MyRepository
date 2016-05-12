package com.jingjiang.thehomeofcar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class RecommendAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles = {"最新", "快报", "视频", "新闻", "用车"};

    public RecommendAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
