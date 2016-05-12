package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inrecommend.VideoData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/11.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private VideoData videoData;
    private Context context;

    public VideoAdapter(Context context) {
        this.context = context;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
        notifyDataSetChanged();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, null);
        VideoViewHolder viewHolder = new VideoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.titleTv.setText(videoData.getResult().getList().get(position).getTitle());
        holder.countTv.setText(videoData.getResult().getList().get(position).getPlaycount() + "播放");
        holder.timeTv.setText(videoData.getResult().getList().get(position).getTime());
        Picasso.with(context).load(videoData.getResult().getList().get(position).getSmallimg()).resize(170, 130).into(holder.iconIv);

    }

    @Override
    public int getItemCount() {
        return videoData != null ? videoData.getResult().getList().size() : 0;
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, timeTv, countTv;
        ImageView iconIv;

        public VideoViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
        }
    }
}
