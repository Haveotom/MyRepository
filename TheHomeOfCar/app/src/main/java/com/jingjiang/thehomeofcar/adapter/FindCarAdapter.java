package com.jingjiang.thehomeofcar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class FindCarAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles = {"品牌", "筛选", "降价", "找二手车"};

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public FindCarAdapter(FragmentManager fm) {
        super(fm);
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
