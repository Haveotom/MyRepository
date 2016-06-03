package com.jingjiang.thehomeofcar.indiscover.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.indiscover.ActivityAreaData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/18.
 */
public class ActivityAreaAdapter extends BaseAdapter {
    private Context context;
    private ActivityAreaData activityAreaData;
    //接口对象

    public ActivityAreaAdapter(Context context) {
        this.context = context;
    }

    public void setActivityAreaData(ActivityAreaData activityAreaData) {
        this.activityAreaData = activityAreaData;
        //通知数据改变
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return activityAreaData != null ? activityAreaData.getResult().getImageads().getImageadsinfo().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_acitivity_area, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(activityAreaData.getResult().getImageads().getImageadsinfo().get(position).getImgurl()).into(holder.imageView);
        return convertView;
    }


    class ViewHolder {
        ImageView imageView;
        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_activity_area_iv);

        }
    }

}
