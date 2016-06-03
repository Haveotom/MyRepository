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
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/12.
 */
public class NewsAdapter extends RecyclerView.Adapter {
    private NewsData newsData;
    private Context context;
    private static final int MESSAGE = 1;
    private static final int PICTURE = 2;
    private MyRvOnClickListener myRvOnClickListener;

    public void setMyRvOnClickListener(MyRvOnClickListener myRvOnClickListener) {
        this.myRvOnClickListener = myRvOnClickListener;
    }

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setNewsData(NewsData newsData) {
        this.newsData = newsData;
        notifyDataSetChanged();
    }

    //根据类型来选择所应该填的item
    @Override
    public int getItemViewType(int position) {
        if (newsData.getResult().getNewslist().get(position).getMediatype() == 10) {
            return PICTURE;
        } else {
            return MESSAGE;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case MESSAGE:
                View messageView = LayoutInflater.from(context).inflate(R.layout.item_r_newest, parent, false);
                holder = new MessageViewHolder(messageView, myRvOnClickListener);
                break;
            case PICTURE:
                View pictureView = LayoutInflater.from(context).inflate(R.layout.item_r_newest_picture, parent, false);
                holder = new PictureViewHolder(pictureView, myRvOnClickListener);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case MESSAGE:
                MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
                messageViewHolder.titleTv.setText(newsData.getResult().getNewslist().get(position).getTitle());
                messageViewHolder.countTv.setText(newsData.getResult().getNewslist().get(position).getReplycount() + "评论");
                messageViewHolder.timeTv.setText(newsData.getResult().getNewslist().get(position).getTime());
                Picasso.with(context).load(
                        newsData.getResult().getNewslist().get(position).getSmallpic()).error(R.mipmap.carlogo)
                        .resize(170, 120).into(messageViewHolder.iconIv);
                break;
            case PICTURE:
                PictureViewHolder pictureViewHolder = (PictureViewHolder) holder;
                pictureViewHolder.pTitleTv.setText(newsData.getResult().getNewslist().get(position).getTitle());
                pictureViewHolder.pTimeTv.setText(newsData.getResult().getNewslist().get(position).getTime());
                pictureViewHolder.pCountTv.setText(newsData.getResult().getNewslist().get(position).getReplycount() + "图片");

                String url = newsData.getResult().getNewslist().get(position).getIndexdetail();
                String[] urls = null;
                urls = url.split("㊣");


                Picasso.with(context).load(urls[0]).resize(200, 130).into(pictureViewHolder.iconOneIv);
                Picasso.with(context).load(urls[1]).resize(200, 130).into(pictureViewHolder.iconTwoIv);
                Picasso.with(context).load(urls[2]).resize(200, 130).into(pictureViewHolder.iconThreeIv);
                break;


        }

    }

    @Override
    public int getItemCount() {
        return newsData != null ? newsData.getResult().getNewslist().size() : 0;
    }

    class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTv, timeTv, countTv;
        ImageView iconIv;

        public MessageViewHolder(View itemView, MyRvOnClickListener listener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
            myRvOnClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (myRvOnClickListener != null) {
                myRvOnClickListener.onItemClick(v, getPosition());
            }

        }
    }

    class PictureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pTitleTv, pTimeTv, pCountTv;
        ImageView iconOneIv, iconTwoIv, iconThreeIv;

        public PictureViewHolder(View itemView, MyRvOnClickListener listener) {
            super(itemView);
            pTitleTv = (TextView) itemView.findViewById(R.id.item_picture_title_tv);
            pTimeTv = (TextView) itemView.findViewById(R.id.item_picture_time_tv);
            pCountTv = (TextView) itemView.findViewById(R.id.item_picture_count_tv);
            iconOneIv = (ImageView) itemView.findViewById(R.id.item_picture_icon1_iv);
            iconTwoIv = (ImageView) itemView.findViewById(R.id.item_picture_icon2_iv);
            iconThreeIv = (ImageView) itemView.findViewById(R.id.item_picture_icon3_iv);
            myRvOnClickListener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (myRvOnClickListener != null) {
                myRvOnClickListener.onItemClick(v, getPosition());
            }

        }
    }
}
