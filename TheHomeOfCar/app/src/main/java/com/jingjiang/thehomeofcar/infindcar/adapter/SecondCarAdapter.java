package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dllo on 16/5/16.
 */
public class SecondCarAdapter extends RecyclerView.Adapter<SecondCarAdapter.MyViewholder> {
    private Context context;
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public SecondCarAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findcar_secondcar, null);
        MyViewholder viewholder = new MyViewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyViewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
