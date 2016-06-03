package com.jingjiang.thehomeofcar.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.adapter.ForumAdapter;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.HotPostFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.UseForumFragment;
import com.jingjiang.thehomeofcar.inforum.fragment.WellSelectionFragment;
import com.jingjiang.thehomeofcar.searchui.SearchActivity;

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
        //字体颜色
        tabLayout.setTabTextColors(Color.GRAY, Color.rgb(0, 180, 255));
        //下划线颜色
        tabLayout.setSelectedTabIndicatorColor(Color.rgb(0, 180, 255));
        bindView(R.id.forum_search_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SearchActivity.class);
                startActivity(intent);

            }
        });


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
