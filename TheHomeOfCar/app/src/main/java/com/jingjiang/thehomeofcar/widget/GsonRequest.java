package com.jingjiang.thehomeofcar.widget;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by dllo on 16/5/12.
 * 加volley包
 */
public class GsonRequest<T> extends Request<T> {
    //相当于以后使用的实体类
    private Class<T> mClass;
    //加Gson包
    private Gson gson;
    private Response.Listener mListener;

    //构造方法中 我们传入的参数
    //第一个: 请求的数据类型
    //第二个: url
    //第三个: 失败时候的回调
    //第四个: 成功时候的回调
    //第五个: 就是实体类
    public GsonRequest(int method,
                       String url,
                       Response.ErrorListener listener,
                       Response.Listener mListener,
                       Class<T> mClass) {
        super(method, url, listener);
        this.mClass = mClass;
        this.mListener = mListener;
        this.gson = new Gson();
    }

    //返回我们想要解析后的数据
    //在这里,首先将response转化成String类型的数据
    //然后通过Gson进行解析转化
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String data = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            // 成功之后的回调,
            // 第一个参数  是我们将data直接解析
            // 第二个参数  就是我们的缓存入口,这里的缓存是规定好的
            // 我们直接将Response请求作为缓存入口
            return Response.success(
                    gson.fromJson(data, mClass),//第一个
                    HttpHeaderParser.parseCacheHeaders(response));//第二个
        } catch (UnsupportedEncodingException e) {
            // 失败之后的回调
            return Response.error(new ParseError(e));
        }
    }

    // 队请求的一个反馈,反馈的就是我们上面定义好的接口对象
    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);

    }
}
