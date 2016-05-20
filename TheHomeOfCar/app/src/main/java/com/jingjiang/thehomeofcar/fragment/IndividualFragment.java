package com.jingjiang.thehomeofcar.fragment;

import android.content.Intent;
import android.view.View;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inindividual.LoginAty;


/**
 * Created by dllo on 16/5/9.
 */
public class IndividualFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public int initLayout() {
        return R.layout.fragment_individual;
    }

    @Override
    public void initView() {
        //点击登录
        bindView(R.id.individual_login_tv).setOnClickListener(this);
        bindView(R.id.individual_zhanghao_ll).setOnClickListener(this);//账号登录
        bindView(R.id.individual_youhuiquan_ll).setOnClickListener(this);//优惠券

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.individual_login_tv:
                startActivity(new Intent(getContext(), LoginAty.class));
                break;
            case R.id.individual_zhanghao_ll:
                startActivity(new Intent(getContext(), LoginAty.class));
                break;
            case R.id.individual_youhuiquan_ll:
                startActivity(new Intent(getContext(), LoginAty.class));
                break;
        }
    }
}
