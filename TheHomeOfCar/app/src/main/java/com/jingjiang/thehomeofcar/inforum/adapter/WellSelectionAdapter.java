package com.jingjiang.thehomeofcar.inforum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inforum.WellSelectionData;
import com.jingjiang.thehomeofcar.myinterface.MyRvOnClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/20.
 */
public class WellSelectionAdapter extends RecyclerView.Adapter<WellSelectionAdapter.WellSelectionViewHolder> {
    private WellSelectionData wellSelectionData;
    private MyRvOnClickListener myRvOnClickListener;
    private Context context;

    public WellSelectionAdapter(Context context) {
        this.context = context;
    }

    public void setMyRvOnClickListener(MyRvOnClickListener myRvOnClickListener) {
        this.myRvOnClickListener = myRvOnClickListener;
    }

    public void setWellSelectionData(WellSelectionData wellSelectionData) {
        this.wellSelectionData = wellSelectionData;
        //通知数据改变
        notifyDataSetChanged();
    }

    @Override
    public WellSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_r_newest, null);
        WellSelectionViewHolder holder = new WellSelectionViewHolder(view, myRvOnClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(WellSelectionViewHolder holder, int position) {
        holder.titleTv.setText(wellSelectionData.getResult().getList().get(position).getTitle());
        holder.forumTv.setText(wellSelectionData.getResult().getList().get(position).getBbsname());
        holder.countTv.setText(wellSelectionData.getResult().getList().get(position).getReplycounts() + "回");
        Picasso.with(context).load(wellSelectionData.getResult().getList().get(position).getSmallpic().replace("club2", "www"))
                .resize(140, 100)
                .error(R.mipmap.carlogo).into(holder.iconIv);

    }

    @Override
    public int getItemCount() {
        return wellSelectionData != null ? wellSelectionData.getResult().getList().size() : 0;
    }

    class WellSelectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTv, countTv, forumTv;
        ImageView iconIv;

        public WellSelectionViewHolder(View itemView, MyRvOnClickListener listener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_video_title_tv);
            countTv = (TextView) itemView.findViewById(R.id.item_video_count_tv);
            forumTv = (TextView) itemView.findViewById(R.id.item_video_time_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_video_icon_iv);
            //给myListener赋值
            myRvOnClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (myRvOnClickListener != null) {
                //获取item和位置
                myRvOnClickListener.onItemClick(v, getPosition());
            }

        }
    }
}
