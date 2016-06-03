package com.jingjiang.thehomeofcar.inindividual;

import android.view.View;
import android.widget.LinearLayout;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseActivity;

/**
 * Created by dllo on 16/5/16.
 */
public class LoginAty extends BaseActivity {
    private LinearLayout exit;

    @Override
    protected int getLayout() {
        return R.layout.aty_individual_login;
    }

    @Override
    protected void initView() {
        exit = bindView(R.id.individual_login_exit);
        //退出该界面
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {

    }
}
