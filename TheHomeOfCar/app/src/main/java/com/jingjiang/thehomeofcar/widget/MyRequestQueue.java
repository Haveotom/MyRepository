package com.jingjiang.thehomeofcar.widget;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.jingjiang.thehomeofcar.base.MyApplication;

/**
 * Created by dllo on 16/5/13.
 * 请求队列的单例
 */
public class MyRequestQueue {

    private static RequestQueue requestQueue;

    public MyRequestQueue() {

    }

    public static RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            synchronized (MyRequestQueue.class) {
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(MyApplication.context);
                }
            }
        }

        return requestQueue;

    }
}
