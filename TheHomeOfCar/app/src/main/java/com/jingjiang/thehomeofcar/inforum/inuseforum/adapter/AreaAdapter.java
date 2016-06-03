package com.jingjiang.thehomeofcar.inforum.inuseforum.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.AreaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/31.
 */
public class AreaAdapter extends BaseExpandableListAdapter {
    private Context context;
    private AreaData areaData;
    private List<String> letter;


    public void setLetter(List<String> letter) {
        this.letter = letter;
    }

    public AreaAdapter(Context context) {
        this.context = context;
    }

    public void setAreaData(AreaData areaData) {
        this.areaData = areaData;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return letter.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 3;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return letter.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return areaData.getResult().getProvinces().get(childPosition);
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
        areaData = new AreaData();
        LetterViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_letter, parent, false);
            holder = new LetterViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (LetterViewHolder) convertView.getTag();
        }
        holder.letterTv.setText(letter.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        NameViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_findcar_brand_every_brand, parent, false);
            holder = new NameViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NameViewHolder) convertView.getTag();
        }
//        if (letter.get(groupPosition) == areaData.getResult().getProvinces().get(areaData.getResult().getProvinces().size()).getFirstletter()) {
//            Log.d("llllllll", letter.get(groupPosition));
//            Log.d("AreaAdapter", areaData.getResult().getProvinces().get(5).getFirstletter());
//            holder.brandTv.setText(areaData.getResult().getProvinces().get(5).getName());
//        }
        holder.iconTv.setVisibility(View.GONE);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class LetterViewHolder {
        TextView letterTv;

        public LetterViewHolder(View itemView) {

            letterTv = (TextView) itemView.findViewById(R.id.item_group_letter_tv);
        }
    }

    class NameViewHolder {
        TextView brandTv;
        ImageView iconTv;

        public NameViewHolder(View itemView) {
            brandTv = (TextView) itemView.findViewById(R.id.item_child_name_tv);
            iconTv = (ImageView) itemView.findViewById(R.id.item_child_icon_iv);
        }
    }
}
