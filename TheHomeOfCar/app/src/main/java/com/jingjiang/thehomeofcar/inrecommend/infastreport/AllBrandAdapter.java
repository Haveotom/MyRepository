package com.jingjiang.thehomeofcar.inrecommend.infastreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jingjiang.thehomeofcar.R;

/**
 * Created by dllo on 16/6/1.
 */
public class AllBrandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private AllBrandData data;

    public void setData(AllBrandData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public AllBrandAdapter(Context context) {
        this.context = context;
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
