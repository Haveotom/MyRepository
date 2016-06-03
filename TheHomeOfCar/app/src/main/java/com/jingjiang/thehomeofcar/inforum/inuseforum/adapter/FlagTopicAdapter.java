package com.jingjiang.thehomeofcar.inforum.inuseforum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/31.
 */
public class FlagTopicAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> forum = new ArrayList<>();

    public void setForum(List<String> forum) {
        this.forum = forum;
        notifyDataSetChanged();
    }

    public FlagTopicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return forum.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return forum.get(groupPosition);
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
//        forum = new ArrayList<>();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_brand, parent, false);
            holder = new NameViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NameViewHolder) convertView.getTag();
        }
        holder.iconTv.setVisibility(View.GONE);
        holder.nameTv.setText(forum.get(groupPosition));
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
