package com.jingjiang.thehomeofcar.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.adapter.ForumAdapter;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.HotPostFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.UseForumFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.WellSelectionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class ForumFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ForumAdapter forumAdapter;
    private List<Fragment> fragments;

    @Override
    public int initLayout() {
        return R.layout.fragment_forum;
    }

    @Override
    public void initView() {
        tabLayout = bindView(R.id.forum_tablayout);
        viewPager = bindView(R.id.forum_viewpager);
        forumAdapter = new ForumAdapter(getChildFragmentManager());
        initFragment();
        forumAdapter.setFragments(fragments);
        viewPager.setAdapter(forumAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY, Color.rgb(0, 180, 255));

        tabLayout.setSelectedTabIndicatorColor(Color.rgb(0, 180, 255));

    }

    @Override
    public void initData() {

    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new WellSelectionFragment());
        fragments.add(new HotPostFragment());
        fragments.add(new UseForumFragment());
    }

}
