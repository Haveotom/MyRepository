package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandHotData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/17.
 */
public class BrandHotAdapter extends BaseAdapter {
    private BrandHotData brandHotData;
    private Context context;

    public BrandHotAdapter(Context context) {
        this.context = context;
    }

    public void setBrandHotData(BrandHotData brandHotData) {
        this.brandHotData = brandHotData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return brandHotData != null ? brandHotData.getResult().getList().size() : 0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hotbrand_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameTv.setText(brandHotData.getResult().getList().get(position).getName());
        Picasso.with(context).load(brandHotData.getResult().getList().get(position).getImg()).resize(70, 70).into(holder.iconIv);
        return convertView;
    }

    class ViewHolder {
        TextView nameTv;
        ImageView iconIv;

        public ViewHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.name_brand_tv);
            iconIv = (ImageView) view.findViewById(R.id.icon_brand_iv);

        }
    }
}
