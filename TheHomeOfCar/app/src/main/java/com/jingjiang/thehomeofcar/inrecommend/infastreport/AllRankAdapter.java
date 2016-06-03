package com.jingjiang.thehomeofcar.inrecommend.infastreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;

/**
 * Created by dllo on 16/6/1.
 */
public class AllRankAdapter extends BaseExpandableListAdapter {
    private Context context;
    private AllRankData data;

    public void setData(AllRankData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public AllRankAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return data != null ? data.getResult().getList().size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.getResult().getList().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        NameViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_brand, parent, false);
            holder = new NameViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NameViewHolder) convertView.getTag();
        }
        holder.iconTv.setVisibility(View.GONE);
        holder.nameTv.setText(data.getResult().getList().get(groupPosition).getLevelname());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;

    }

    class NameViewHolder {
        TextView nameTv;
        ImageView iconTv;

        public NameViewHolder(View itemView) {
            nameTv = (TextView) itemView.findViewById(R.id.item_child_name_tv);
            iconTv = (ImageView) itemView.findViewById(R.id.item_child_icon_iv);
        }
    }
}
