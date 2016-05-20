package com.jingjiang.thehomeofcar.indiscover.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.bean.indiscover.ActivityAreaData;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/17.
 */
public class CarMediaAdapter extends RecyclerView.Adapter<CarMediaAdapter.ActivityViewHolder> {
    private Context context;
    private ActivityAreaData activityAreaData;
    private ItemClickListener itemClickListener;

    public CarMediaAdapter(Context context) {
        this.context = context;
    }

    public void setActivityAreaData(ActivityAreaData activityAreaData) {
        this.activityAreaData = activityAreaData;
        notifyDataSetChanged();
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car_media, null);
        ActivityViewHolder viewHolder = new ActivityViewHolder(view, itemClickListener);
        return viewHolder;
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(ItemClickListener listener) {
        this.itemClickListener = listener;

    }


    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        holder.nameTv.setText(activityAreaData.getResult().getFunctionlist().get(position).getTitle());
        Picasso.with(context).load(activityAreaData.getResult().getFunctionlist().get(position).getIconurl())
                .resize(80, 80).into(holder.iconIv);

    }

    @Override
    public int getItemCount() {
        return activityAreaData != null ? activityAreaData.getResult().getFunctionlist().size() : 0;
    }


    public class ActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTv;
        ImageView iconIv;


        //添加ItemClickListener 实现其接口
        public ActivityViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.item_car_media_name_tv);
            iconIv = (ImageView) itemView.findViewById(R.id.item_car_media_icon_iv);
            itemClickListener = listener;//赋值
            itemView.setOnClickListener(this);//给每行设置监听
        }

        //点击监听
        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getPosition());
            }

        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
