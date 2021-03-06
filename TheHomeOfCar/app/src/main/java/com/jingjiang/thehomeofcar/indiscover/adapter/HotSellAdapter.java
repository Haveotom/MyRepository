package com.jingjiang.thehomeofcar.indiscover.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.indiscover.HotSellData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/18.
 */
public class HotSellAdapter extends BaseAdapter {
    private HotSellData hotSellData;
    private Context context;

    public HotSellAdapter(Context context) {
        this.context = context;
    }

    public void setHotSellData(HotSellData hotSellData) {
        this.hotSellData = hotSellData;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return hotSellData != null ? hotSellData.getResult().getModulelist().get(0).getList().size() : 0;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hot_sell, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int i = 0;
        if (hotSellData.getResult().getModulelist().size() == 2) {
            Picasso.with(context).load(hotSellData.getResult().getModulelist().get(i).getList().get(position).getLogo())
                    .into(holder.iconIv);

            holder.titleTv.setText(hotSellData.getResult().getModulelist().get(i).getList().get(position).getTitle());
            holder.adinfoTv.setText(hotSellData.getResult().getModulelist().get(i).getList().get(position).getAdinfo());
            holder.priceTv.setText(hotSellData.getResult().getModulelist().get(i).getList().get(position).getPrice());
            holder.fctPriceTv.setText(hotSellData.getResult().getModulelist().get(i).getList().get(position).getFctprice());
            //设置textview的线
            holder.fctPriceTv.getPaint().setAntiAlias(true);//抗锯齿
//        holder.fctPriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
            holder.fctPriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);//设置中线并加清晰
//        holder.fctPriceTv.getPaint().setFlags(0);//取消设置的划线

        }


        return convertView;
    }

    class ViewHolder {
        TextView titleTv, priceTv, fctPriceTv, adinfoTv;
        ImageView iconIv;

        public ViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_hot_sell_title_tv);
            priceTv = (TextView) view.findViewById(R.id.item_hot_sell_price_tv);
            fctPriceTv = (TextView) view.findViewById(R.id.item_hot_sell_fctprice);
            adinfoTv = (TextView) view.findViewById(R.id.item_hot_sell_adinfo_tv);
            iconIv = (ImageView) view.findViewById(R.id.item_hot_sell_icon);

        }
    }
}
