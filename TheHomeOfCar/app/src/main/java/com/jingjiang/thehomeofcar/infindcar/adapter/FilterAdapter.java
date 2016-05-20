package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.infindcar.FilterData;

import java.util.zip.Inflater;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/16.
 */
public class FilterAdapter extends BaseAdapter {
    private FilterData filterData;
    private Context context;

    public FilterAdapter(Context context) {
        this.context = context;
    }

    public void setFilterData(FilterData filterData) {
        this.filterData = filterData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return filterData != null ? filterData.getResult().getSeries().size() : 0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_filter, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.brandTv.setText(filterData.getResult().getSeries().get(position).getSeriesname());
        holder.priceTv.setText(filterData.getResult().getSeries().get(position).getPricerange());
        Picasso.with(context).load(filterData.getResult().getSeries().get(position).getThumburl()).
                resize(140, 100).into(holder.iconTv);
        if (filterData.getResult().getSeries().get(position).getCornericon() != "") {
            holder.paihangIv.setVisibility(View.VISIBLE);
            holder.numberTv.setText(filterData.getResult().getSeries().get(position).getCornericon());
        } else {
            holder.paihangIv.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    class ViewHolder {
        TextView brandTv, priceTv, numberTv;
        ImageView iconTv, paihangIv;

        public ViewHolder(View view) {
            brandTv = (TextView) view.findViewById(R.id.item_filter_name);
            priceTv = (TextView) view.findViewById(R.id.item_filter_price);
            iconTv = (ImageView) view.findViewById(R.id.item_filter_icon);
            numberTv = (TextView) view.findViewById(R.id.item_filter_number);
            paihangIv = (ImageView) view.findViewById(R.id.item_filter_paihangbang);


        }
    }
}
