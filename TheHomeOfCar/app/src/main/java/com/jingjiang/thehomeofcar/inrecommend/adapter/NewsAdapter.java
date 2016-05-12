package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewsData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/12.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private NewsData newsData;
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setNewsData(NewsData newsData) {
        this.newsData = newsData;
        notifyDataSetChanged();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, null);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.titleTv.setText(newsData.getResult().getNewslist().get(position).getTitle());
        holder.countTv.setText(newsData.getResult().getNewslist().get(position).getReplycount() + "评论");
        holder.timeTv.setText(newsData.getResult().getNewslist().get(position).getTime());
        Picasso.with(context).load(
                newsData.getResult().getNewslist().get(position).getSmallpic()).resize(170, 130).into(holder.iconIv);

    }

    @Override
    public int getItemCount() {
        return newsData != null ? newsData.getResult().getNewslist().size() : 0;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv, timeTv, countTv;
        ImageView iconIv;

        public NewsViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
        }
    }
}
