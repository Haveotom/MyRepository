package com.jingjiang.thehomeofcar.widget;

import android.content.Context;

import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by dllo on 16/5/14.
 * 让ListView不可滑动
 */
public class NoScrollListView extends ListView {


    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //设置不滚动
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >>2,//如果不设置,系统默认设置是显示两条
                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
