package com.jingjiang.thehomeofcar.inrecommend.adapter;

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
public class NewestAdapter extends RecyclerView.Adapter<NewestAdapter.NewestViewHolder> {
    private List<String> data;
    private Context context;//要用到context

    public NewestAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public NewestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, null);
        NewestViewHolder viewHolder = new NewestViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewestViewHolder holder, int position) {
//        holder.iconIv.setImageResource(data.get(position));
        holder.timeTv.setText(data.get(position));
        holder.countTv.setText(data.get(position));
        holder.titleTv.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    class NewestViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, countTv, timeTv;
        ImageView iconIv;

        public NewestViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_hotpost_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_newest_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_hotpost_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_newest_icon_iv);
        }
    }
}
