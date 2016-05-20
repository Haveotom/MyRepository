package com.jingjiang.thehomeofcar.indiscover.adapter;

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
 * 商品列表
 */
public class BrandListAdapter extends BaseAdapter {
    private HotSellData hotSellData;

    public void setHotSellData(HotSellData hotSellData) {
        this.hotSellData = hotSellData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return hotSellData != null ? hotSellData.getResult().getGoodslist().getList().size() : 0;
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
            convertView = LayoutInflater.from(MyApplication.context).inflate(R.layout.item_brandlist, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(hotSellData.getResult().getGoodslist().getList().get(position).getTitle());
        holder.adinfoTv.setText(hotSellData.getResult().getGoodslist().getList().get(position).getAdinfo());
        holder.priceTv.setText(hotSellData.getResult().getGoodslist().getList().get(position).getPrice());
        holder.fctPriceTv.setText(hotSellData.getResult().getGoodslist().getList().get(position).getFctprice());
        holder.fctPriceTv.getPaint().setAntiAlias(true);
        holder.fctPriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);//中划线 清晰
        Picasso.with(MyApplication.context).load(hotSellData.getResult().getGoodslist().getList().get(position).getLogo()).
                resize(170, 120).into(holder.iconIv);
        return convertView;
    }

    class ViewHolder {
        TextView titleTv, priceTv, fctPriceTv, adinfoTv;
        ImageView iconIv;

        public ViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_brandlist_title_tv);
            priceTv = (TextView) view.findViewById(R.id.item_brandlist_price_tv);
            fctPriceTv = (TextView) view.findViewById(R.id.item_brandlist_fctprice_tv);
            adinfoTv = (TextView) view.findViewById(R.id.item_brandlist_adinfo_tv);
            iconIv = (ImageView) view.findViewById(R.id.item_brandlist_icon_iv);

        }
    }
}
