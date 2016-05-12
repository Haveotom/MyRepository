package com.jingjiang.thehomeofcar.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;
import com.jingjiang.thehomeofcar.fragment.DiscoverFragment;
import com.jingjiang.thehomeofcar.fragment.FindCarFragment;
import com.jingjiang.thehomeofcar.fragment.ForumFragment;
import com.jingjiang.thehomeofcar.fragment.IndividualFragment;
import com.jingjiang.thehomeofcar.fragment.RecommendFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton recommendBtn, findCarBtn, forumBtn, individualBtn, discoverBtn;
    private int[] ids = {R.id.main_recommend_btn, R.id.main_forum_btn,
            R.id.main_findcar_btn, R.id.main_discover_btn, R.id.main_individul_btn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.replace_fragment, new RecommendFragment());//FramLayout布局替换
        transaction.commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < ids.length; i++) {
            bindView(ids[i]).setOnClickListener(this);
        }
        recommendBtn = bindView(R.id.main_recommend_btn);
        recommendBtn.setChecked(true);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_recommend_btn:
                transaction.replace(R.id.replace_fragment, new RecommendFragment());
                break;
            case R.id.main_forum_btn:
                transaction.replace(R.id.replace_fragment, new ForumFragment());
                break;
            case R.id.main_findcar_btn:
                transaction.replace(R.id.replace_fragment, new FindCarFragment());
                break;
            case R.id.main_discover_btn:
                transaction.replace(R.id.replace_fragment, new DiscoverFragment());
                break;
            case R.id.main_individul_btn:
                transaction.replace(R.id.replace_fragment, new IndividualFragment());
                break;
        }
        transaction.commit();

    }
}
