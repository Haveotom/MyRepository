package com.jingjiang.thehomeofcar.infindcar.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;
import com.jingjiang.thehomeofcar.bean.infindcar.NewBrandData;

import it.sephiroth.android.library.picasso.Picasso;


public class BrandAdapter extends BaseExpandableListAdapter {
    private NewBrandData brandData;
    private Context context;

    public BrandAdapter(Context context) {
        this.context = context;
    }

    //数据类
    public void setBrandData(NewBrandData brandData) {
        this.brandData = brandData;
        //更新后改变
        notifyDataSetChanged();

    }

    @Override
    public int getGroupCount() {
        return brandData != null ? brandData.getResult().getBrandlist().size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return brandData != null ? brandData.getResult().getBrandlist().get(groupPosition).getList().size() : 0;
    }

    //得到父item的数据
    @Override
    public Object getGroup(int groupPosition) {
        return brandData.getResult().getBrandlist().get(groupPosition);
    }

    //得到子item需要关联的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return brandData.getResult().getBrandlist().get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return brandData.getResult().getBrandlist().get(groupPosition).getList().get(childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_letter, parent, false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        holder.letterTv.setText(brandData.getResult().getBrandlist().get(groupPosition).getLetter());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildiewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_brand, parent, false);
            holder = new ChildiewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildiewHolder) convertView.getTag();
        }
        holder.brandTv.setText(brandData.getResult().getBrandlist().get(groupPosition).getList().get(childPosition).getName());

        Picasso.with(context).load(brandData.getResult().getBrandlist().get(groupPosition).getList().get(childPosition).getImgurl()).
                error(R.mipmap.car_logp_l).resize(70, 70).into(holder.iconIv);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class GroupViewHolder {
        TextView letterTv;

        public GroupViewHolder(View itemView) {
            letterTv = (TextView) itemView.findViewById(R.id.item_group_letter_tv);

        }
    }

    class ChildiewHolder {
        TextView brandTv;
        ImageView iconIv;

        public ChildiewHolder(View itemView) {
            brandTv = (TextView) itemView.findViewById(R.id.item_child_name_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_child_icon_iv);
        }
    }
}