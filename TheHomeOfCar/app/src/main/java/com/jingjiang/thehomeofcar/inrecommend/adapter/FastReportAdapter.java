package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.inrecommend.FastReportData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/11.
 */
public class FastReportAdapter extends RecyclerView.Adapter<FastReportAdapter.FastReportViewHolder> {
    private Context context;//为了注入布局使用
    private FastReportData fastReportData;

    public void setFastReportDatas(FastReportData fastReportData) {
        this.fastReportData = fastReportData;
        notifyDataSetChanged();
    }

    //赋值context,,否则用不了
    public FastReportAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return fastReportData != null ? fastReportData.getResult().getList().size() : 0;
    }

    @Override
    public FastReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_fastreport, parent, false);
        FastReportViewHolder viewHolder = new FastReportViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FastReportViewHolder holder, int position) {

        holder.typeNameTv.setText(fastReportData.getResult().getList().get(position).getTypename());
        holder.titleTv.setText(fastReportData.getResult().getList().get(position).getTitle());
        holder.reviewcountTv.setText(fastReportData.getResult().getList().get(position).getReviewcount() + "人浏览");
        holder.timeTv.setText(fastReportData.getResult().getList().get(position).getCreatetime());
        Picasso.with(context).load(fastReportData.getResult().getList().get(position).getBgimage()).resize(800,350).into(holder.pictureTv);


    }


    class FastReportViewHolder extends RecyclerView.ViewHolder {
        TextView typeNameTv, titleTv, reviewcountTv, timeTv;
        ImageView pictureTv;

        public FastReportViewHolder(View itemView) {
            super(itemView);
            typeNameTv = (TextView) itemView.findViewById(R.id.item_fastreport_newspaper);
            titleTv = (TextView) itemView.findViewById(R.id.item_fastreport_topic);
            reviewcountTv = (TextView) itemView.findViewById(R.id.item_fastreport_browser);
            timeTv = (TextView) itemView.findViewById(R.id.item_fastreport_time);
            pictureTv = (ImageView) itemView.findViewById(R.id.item_fastreport_picture);
        }
    }

}
