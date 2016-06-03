package com.jingjiang.thehomeofcar.infindcar.indepreciate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.infindcar.BrandData;

/**
 * Created by dllo on 16/6/2.
 */
public class DepreciateBrandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private BrandData data;

    public DepreciateBrandAdapter(Context context) {
        this.context = context;
    }

    public void setData(BrandData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return data != null ? data.getResult().getBrandlist().size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data != null ? data.getResult().getBrandlist().get(groupPosition).getList().size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.getResult().getBrandlist().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.getResult().getBrandlist().get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
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
        holder.letterTv.setText(data.getResult().getBrandlist().get(groupPosition).getLetter());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildVieHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_brand, parent, false);
            holder = new ChildVieHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChildVieHolder) convertView.getTag();
        }
        holder.brandTv.setText(data.getResult().getBrandlist().get(groupPosition).getList().get(childPosition).getName());
        holder.iconIv.setVisibility(View.GONE);
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

    class ChildVieHolder {
        TextView brandTv;
        ImageView iconIv;

        public ChildVieHolder(View itemView) {
            brandTv = (TextView) itemView.findViewById(R.id.item_child_name_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_child_icon_iv);

        }


    }
}
