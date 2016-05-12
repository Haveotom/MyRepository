package com.jingjiang.thehomeofcar.inforum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;

import java.util.List;

/**
 * Created by dllo on 16/5/11.
 */
public class HotPostAdapter extends RecyclerView.Adapter<HotPostAdapter.HotpostViewHolder> {
    private Context context;
    private List<String> data;

    public HotPostAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public HotpostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forum_hotpost, null);
        HotpostViewHolder viewHolder = new HotpostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HotpostViewHolder holder, int position) {
        holder.titleTv.setText(data.get(position));
        holder.forumTv.setText(data.get(position));
        holder.timeTv.setText(data.get(position));
        holder.numberTv.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class HotpostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, forumTv, timeTv, numberTv;
        ImageView pictureIv;

        public HotpostViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            forumTv = (TextView) itemView.findViewById(R.id.item_hotpost_forum__tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            numberTv = (TextView) itemView.findViewById(R.id.item_hotpost_number_tv);
            pictureIv = (ImageView) itemView.findViewById(R.id.item_hotpost_picture_Iv);
        }
    }
}
