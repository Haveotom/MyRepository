package com.jingjiang.thehomeofcar.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.adapter.RecommendAdapter;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inrecommend.frament.FastReportFragment;
import com.jingjiang.thehomeofcar.inrecommend.frament.NewestFragment;
import com.jingjiang.thehomeofcar.inrecommend.frament.NewsFragment;
import com.jingjiang.thehomeofcar.inrecommend.frament.UseCarFragment;
import com.jingjiang.thehomeofcar.inrecommend.frament.VideoFragment;
import com.jingjiang.thehomeofcar.searchui.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class RecommendFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecommendAdapter recommendAdapter;
    private List<Fragment> fragments;

    @Override
    public int initLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        tabLayout = bindView(R.id.recommend_tablayout);
        viewPager = bindView(R.id.recommend_viewpager);


        initFragment();//将fragment数据初始化
        recommendAdapter = new RecommendAdapter(getChildFragmentManager());//必须要用Child,因为是儿子管它自己,不能父亲管儿子
        //将数据放到Adapter里
        recommendAdapter.setFragments(fragments);
        viewPager.setAdapter(recommendAdapter);
        //让viewpager和tablayout联系起来
        tabLayout.setupWithViewPager(viewPager);
        //设置tablayout
        tabLayout.setTabTextColors(Color.GRAY, Color.rgb(0, 180, 255));//字体的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.rgb(0, 180, 255));//设置线的颜色
        //56abe4

        bindView(R.id.recommend_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SearchActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new NewestFragment());
        fragments.add(new FastReportFragment());
        fragments.add(new VideoFragment());
        fragments.add(new NewsFragment());
        fragments.add(new UseCarFragment());

    }

    @Override
    public void initData() {
//        viewPager.setCurrentItem(2);
        viewPager.setCurrentItem(0);
//        viewPager.setCurrentItem(3);
//        viewPager.setCurrentItem(0);

    }
}
