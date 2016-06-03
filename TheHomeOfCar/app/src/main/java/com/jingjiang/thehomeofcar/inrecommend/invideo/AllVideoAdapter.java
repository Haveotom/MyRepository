package com.jingjiang.thehomeofcar.inrecommend.invideo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/6/1.
 */
public class AllVideoAdapter extends BaseAdapter {
    private Context context;
    private List<String> itemList = new ArrayList<>();//注意初始化
    private  ViewHolder holder = null;

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public AllVideoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList != null ? itemList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_video_name, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameTv.setText(itemList.get(position));

        return convertView;
    }

    public void setColor(int position) {
        holder.nameTv.setTextColor(context.getResources().getColor(R.color.blue_middle));
        holder.checkIv.setVisibility(View.VISIBLE);

    }

    class ViewHolder {
        TextView nameTv;
        ImageView checkIv;

        public ViewHolder(View itemView) {
            nameTv = (TextView) itemView.findViewById(R.id.item_video_fenlei_tv);
            checkIv = (ImageView) itemView.findViewById(R.id.item_video_duihao_iv);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    checkIv.setVisibility(View.VISIBLE);
//                    nameTv.setTextColor(context.getResources().getColor(R.color.blue_middle));
//                }
//            });

        }
    }
}
