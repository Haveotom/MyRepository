package com.jingjiang.thehomeofcar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by dllo on 16/5/26.
 */
public class MyExpandableListView extends ExpandableListView {

    public MyExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
