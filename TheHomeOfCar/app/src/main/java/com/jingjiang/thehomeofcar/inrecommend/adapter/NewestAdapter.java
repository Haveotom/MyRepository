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
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/11.
 * 用欧
 */
public class NewestAdapter extends RecyclerView.Adapter {
    private NewestData newestData;
    private Context context;//要用到context
    private static final int MESSAGE = 1;
    private static final int PICTURE = 2;
    private MyRvOnClickListener myRvOnClickListener;


    //用该方法,返回指定pos位置的行布局类型
    public int getItemViewType(int position) {
        if (newestData.getResult().getNewslist().get(position).getMediatype() == 6) {
            return PICTURE;
        } else {
            return MESSAGE;
        }

    }

    //监听的方法
    public void setMyRvOnClickListener(MyRvOnClickListener myRvOnClickListener) {
        this.myRvOnClickListener = myRvOnClickListener;
    }

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

    //绑定布局

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        //根据不同的viewType来创建相对应的ViewHolder
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
        //根据位置position拿到对应的ViewType
        int viewType = getItemViewType(position);
        switch (viewType) {
            case MESSAGE:
                //强转holder,为了显示不同
                MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
                messageViewHolder.titleTv.setText(newestData.getResult().getNewslist().get(position).getTitle());
                int replyCount = newestData.getResult().getNewslist().get(position).getReplycount();
                int media = newestData.getResult().getNewslist().get(position).getMediatype();
                if (media == 3) {
                    messageViewHolder.countTv.setText(replyCount + "播放");

                } else if (media == 2) {
                    messageViewHolder.countTv.setText(replyCount + "评论");
                    messageViewHolder.shuokeTv.setVisibility(View.VISIBLE);

                } else if (media == 1) {
                    messageViewHolder.shuokeTv.setVisibility(View.GONE);
                    messageViewHolder.countTv.setText(replyCount + "评论");
                } else if (media == 5) {
                    messageViewHolder.countTv.setText(replyCount + "回帖");
                } else {
                    messageViewHolder.countTv.setText(replyCount + "图片");
                }


                messageViewHolder.timeTv.setText(newestData.getResult().getNewslist().get(position).getTime());
                if (newestData.getResult().getNewslist().get(position).getMediatype() == 5) {
                    Picasso.with(context).load(newestData.getResult().getNewslist().get(position).getSmallpic().replace("club2", "www"))
                            .resize(170, 120).error(R.mipmap.carlogo).into(messageViewHolder.iconIv);

                } else {
                    Picasso.with(context).load(newestData.getResult().getNewslist().get(position).getSmallpic())
                            .resize(170, 120).error(R.mipmap.carlogo).into(messageViewHolder.iconIv);
                }


                break;
            case PICTURE:
                PictureViewHolder pictureViewHolder = (PictureViewHolder) holder;
                pictureViewHolder.pTitleTv.setText(newestData.getResult().getNewslist().get(position).getTitle());
                pictureViewHolder.pTimeTv.setText(newestData.getResult().getNewslist().get(position).getTime());
                pictureViewHolder.pCountTv.setText(newestData.getResult().getNewslist().get(position).getReplycount() + "图片");

                String url = newestData.getResult().getNewslist().get(position).getIndexdetail();
                String[] twoPart = null;
                twoPart = url.split("㊣");
                String[] urls = twoPart[2].split(",");
                Picasso.with(context).load(urls[0]).resize(200, 130).into(pictureViewHolder.iconOneIv);
                Picasso.with(context).load(urls[1]).resize(200, 130).into(pictureViewHolder.iconTwoIv);
                Picasso.with(context).load(urls[2]).resize(200, 130).into(pictureViewHolder.iconThreeIv);
                break;
        }

    }


    //因为有两个布局,因此就需要两个ViewHolder
    //新闻的viewholder
    class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTv, countTv, timeTv, shuokeTv;
        ImageView iconIv;


        public MessageViewHolder(View itemView, MyRvOnClickListener listener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            timeTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
            shuokeTv = (TextView) itemView.findViewById(R.id.item_video_shuoke_tv);
            myRvOnClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (myRvOnClickListener != null) {
                myRvOnClickListener.onItemClick(itemView, getPosition());

            }

        }
    }

    //加载横着的图片的viewholder
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
                myRvOnClickListener.onItemClick(itemView, getPosition());
            }

        }
    }


}
