package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inrecommend.UseCarData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/12.
 */
public class UseCarAdapter extends RecyclerView.Adapter<UseCarAdapter.UseCarViewHolder> {
    private UseCarData useCarData;
    private Context context;

    public UseCarAdapter(Context context) {
        this.context = context;
    }

    public void setUseCarData(UseCarData useCarData) {
        this.useCarData = useCarData;
        notifyDataSetChanged();
    }

    @Override
    public UseCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, null);
        UseCarViewHolder useCarViewHolder = new UseCarViewHolder(view);
        return useCarViewHolder;
    }

    @Override
    public void onBindViewHolder(UseCarViewHolder holder, int position) {
        holder.titleTv.setText(useCarData.getResult().getNewslist().get(position).getTitle());
        holder.countTv.setText(useCarData.getResult().getNewslist().get(position).getReplycount() + "评论");
        holder.timeTv.setText(useCarData.getResult().getNewslist().get(position).getTime());
        Picasso.with(context).load(
                useCarData.getResult().getNewslist().get(position).getSmallpic()).
                resize(170, 130).into(holder.iconIv);

    }

    @Override
    public int getItemCount() {
        return useCarData != null ? useCarData.getResult().getNewslist().size() : 0;
    }

    class UseCarViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, timeTv, countTv;
        ImageView iconIv;

        public UseCarViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
        }
    }
}
