package com.jingjiang.thehomeofcar.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/5/9.
 * 我们自己的application
 * 在使用的时候,还需要在清单文件中注册
 */
public class MyApplication extends Application {
    public static Context context;
    //Application创建的原因四我们需要一个属于自己的大"环境"(context)
    //保证自己的App拥有单独的一个context对象

    //第一个生命周期中我们对context赋值
    @Override
    public void onCreate() {
        super.onCreate();
        //this代表当前的环境
        context = this;//赋值为this,context便有值
    }

    //对外提供一个方法,这个方法就是让别的类获取自己的context
    public static Context getContext() {
        return context;
    }
}
