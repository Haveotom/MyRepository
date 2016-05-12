package com.jingjiang.thehomeofcar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class ForumAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles = {"精选推荐", "热帖", "常用论坛"};

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public ForumAdapter(FragmentManager fm) {
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
