package com.jingjiang.thehomeofcar.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/5/9.
 * 我们自己的application
 * 在使用的时候,还需要在清单文件中注册
 */
public class MyApplication extends Application {
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;//赋值为this,context便有值
    }
}
