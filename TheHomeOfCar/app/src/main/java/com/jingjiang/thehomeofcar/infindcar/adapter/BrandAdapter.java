package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/13.
 */
public class BrandAdapter extends BaseAdapter {
    private Context context;
    private BrandData brandData;

    public void setBrandData(BrandData brandData) {
        this.brandData = brandData;
        notifyDataSetChanged();
    }

    public BrandAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return brandData != null ? brandData.getResult().getBrandlist().size() : 0;
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
        BrandViewHolder holder;
        List<String> data = new ArrayList<>();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand, null);
            holder = new BrandViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (BrandViewHolder) convertView.getTag();
        }
        holder.letterTv.setText(brandData.getResult().getBrandlist().get(position).getLetter());
        for (int i = 0; i < brandData.getResult().getBrandlist().size(); i++) {
            for (int j = 0; j < brandData.getResult().getBrandlist().get(i).getList().size(); j++) {
//                holder.nameTv.setText(brandData.getResult().getBrandlist().get(i).getList().get(position).getName());
                data.add(brandData.getResult().getBrandlist().get(i).getList().get(j).getName());
                Picasso.with(context).load(brandData.getResult().getBrandlist().get(i).getList().get(j).getImgurl())
                        .resize(50, 50).into(holder.iconIv);

            }

        }
        holder.nameTv.setText(data.get(1));

        return convertView;
    }

    class BrandViewHolder {
        TextView letterTv, nameTv;
        ImageView iconIv;

        public BrandViewHolder(View itemView) {
            letterTv = (TextView) itemView.findViewById(R.id.item_brand_letter_tv);
            nameTv = (TextView) itemView.findViewById(R.id.item_brand_name_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_brand_icon_iv);


        }
    }

}
