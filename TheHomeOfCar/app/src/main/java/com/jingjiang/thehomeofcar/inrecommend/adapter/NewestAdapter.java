package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.BuildConfig;
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, parent, false);
        NewestViewHolder viewHolder = new NewestViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewestViewHolder holder, int position) {
        holder.titleTv.setText(newestData.getResult().getNewslist().get(position).getTitle());
        int replyCount = newestData.getResult().getNewslist().get(position).getReplycount();
        int media = newestData.getResult().getNewslist().get(position).getMediatype();
        if (media == 3) {
            holder.countTv.setText(replyCount + "播放");

        } else if (media == 2 || media == 1) {
            holder.countTv.setText(replyCount + "评论");
        } else if (media == 5) {
            holder.countTv.setText(replyCount + "回帖");
        } else {
            holder.countTv.setText(replyCount + "图片");
        }
        holder.timeTv.setText(newestData.getResult().getNewslist().get(position).getTime());

        if (newestData.getResult().getNewslist().get(position).getSmallpic() != "") {
            Picasso.with(context).load(newestData.getResult().getNewslist().get(position).getSmallpic().replace(" ", "")).
                    error(R.mipmap.ic_launcher).resize(170, 120).
                    into(holder.iconIv);
        } else {
            holder.layout.setVisibility(View.VISIBLE);


            String url = newestData.getResult().getNewslist().get(position).getIndexdetail();
            Log.d("NewestAdapter", newestData.getResult().getNewslist().get(position).getIndexdetail());
            String[] urls = null;
            urls = url.split(",");
            Log.d("NewestAdapter2", urls[0].substring(10));
            Picasso.with(context).load(urls[0].substring(10)).resize(200, 130).into(holder.iconOneIv);
            Picasso.with(context).load(urls[1]).resize(200, 130).into(holder.iconTwoIv);
            Picasso.with(context).load(urls[2]).resize(200, 130).into(holder.iconThreeIv);
            holder.pTitleTv.setText(newestData.getResult().getNewslist().get(position).getTitle());
            holder.pTimeTv.setText(newestData.getResult().getNewslist().get(position).getTime());
            holder.pCountTv.setText(newestData.getResult().getNewslist().get(position).getReplycount() + "图片");

        }


    }


    class NewestViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, countTv, timeTv, pTitleTv, pTimeTv, pCountTv;
        ImageView iconIv, iconOneIv, iconTwoIv, iconThreeIv;
        LinearLayout layout;
        RelativeLayout relativeLayout;

        public NewestViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
            pTitleTv = (TextView) itemView.findViewById(R.id.item_video2_title_tv);
            pTimeTv = (TextView) itemView.findViewById(R.id.item_video2_time_tv);
            pCountTv = (TextView) itemView.findViewById(R.id.item_video2_count_tv);
            iconOneIv = (ImageView) itemView.findViewById(R.id.item_video2_icon1_iv);
            iconTwoIv = (ImageView) itemView.findViewById(R.id.item_video2_icon2_iv);
            iconThreeIv = (ImageView) itemView.findViewById(R.id.item_video2_icon3_iv);
            layout = (LinearLayout) itemView.findViewById(R.id.newest_picture_ll);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        }
    }


}
