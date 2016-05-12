package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewestData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/11.
 */
public class NewestAdapter extends RecyclerView.Adapter<NewestAdapter.NewestViewHolder> {
    private NewestData newestData;
    private Context context;//要用到context

    public NewestAdapter(Context context) {
        this.context = context;
    }

    public void setNewestData(NewestData newestData) {
        this.newestData = newestData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newestData != null ? newestData.getResult().getNewslist().size() : 0;
    }

    @Override
    public NewestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, parent,false);
        NewestViewHolder viewHolder = new NewestViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewestViewHolder holder, int position) {
        holder.titleTv.setText(newestData.getResult().getNewslist().get(position).getTitle());
        holder.countTv.setText(newestData.getResult().getNewslist().get(position).getReplycount()+"播放");
        holder.timeTv.setText(newestData.getResult().getNewslist().get(position).getTime());
        Picasso.with(context).load(newestData.getResult().getNewslist().get(position).getSmallpic()).resize(170,130).into(holder.iconIv);

    }


    class NewestViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, countTv, timeTv;
        ImageView iconIv;

        public NewestViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
        }
    }
}
