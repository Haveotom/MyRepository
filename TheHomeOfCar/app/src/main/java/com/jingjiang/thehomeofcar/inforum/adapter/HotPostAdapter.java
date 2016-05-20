package com.jingjiang.thehomeofcar.inforum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inforum.HotPostData;

import java.util.List;

/**
 * Created by dllo on 16/5/11.
 */
public class HotPostAdapter extends RecyclerView.Adapter<HotPostAdapter.HotpostViewHolder> {
    private Context context;
    private HotPostData hotPostData;

    public HotPostAdapter(Context context) {
        this.context = context;
    }

    public void setHotPostData(HotPostData hotPostData) {
        this.hotPostData = hotPostData;
        notifyDataSetChanged();
    }

    @Override
    public HotpostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forum_hotpost, null);
        HotpostViewHolder viewHolder = new HotpostViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return hotPostData != null ? hotPostData.getResult().getList().size() : 0;
    }

    @Override
    public void onBindViewHolder(HotpostViewHolder holder, int position) {
        holder.titleTv.setText(hotPostData.getResult().getList().get(position).getTitle());
        holder.timeTv.setText(hotPostData.getResult().getList().get(position).getPostdate());
        holder.numberTv.setText(hotPostData.getResult().getList().get(position).getReplycounts() + "回帖");
        holder.forumTv.setText(hotPostData.getResult().getList().get(position).getBbsname());
        if (hotPostData.getResult().getList().get(position).getIspictopic() == 1) {
            holder.pictureIv.setVisibility(View.VISIBLE);
        } else {
            holder.pictureIv.setVisibility(View.INVISIBLE);
        }


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
