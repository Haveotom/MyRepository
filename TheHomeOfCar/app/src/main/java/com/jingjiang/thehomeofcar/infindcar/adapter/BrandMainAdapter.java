package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandMainData;

import org.w3c.dom.Text;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/17.
 */
public class BrandMainAdapter extends BaseAdapter {
    private BrandMainData mainData;
    private Context context;

    public BrandMainAdapter(Context context) {
        this.context = context;
    }

    public void setMainData(BrandMainData mainData) {
        this.mainData = mainData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mainData != null ? mainData.getResult().getList().size() : 0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_brand_main_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameTv.setText(mainData.getResult().getList().get(position).getSeriesname());
        Picasso.with(MyApplication.context).load(mainData.getResult().getList().get(position).getImg()).
                resize(200,140).
                into(holder.iconIv);
        return convertView;
    }

    class ViewHolder {
        TextView nameTv;
        ImageView iconIv;

        public ViewHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.brand_main_name_tv);
            iconIv = (ImageView) view.findViewById(R.id.brand_main_icon_iv);

        }
    }
}
