package com.jingjiang.thehomeofcar.infindcar.adapter;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.infindcar.DepreciateData;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/16.
 */
public class DepreciateAdapter extends RecyclerView.Adapter<DepreciateAdapter.DepreciateViewHolder> {
    private DepreciateData depreciateData;
    private Context context;

    public DepreciateAdapter(Context context) {
        this.context = context;
    }

    public void setDepreciateData(DepreciateData depreciateData) {
        this.depreciateData = depreciateData;
        notifyDataSetChanged();
    }

    @Override
    public DepreciateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findcar_depreciate, parent, false);
        DepreciateViewHolder holder = new DepreciateViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DepreciateViewHolder holder, final int position) {
        if (depreciateData.getResult().getCarlist().get(position).getSeriesname() != "") {
            holder.seriesnameTv.setText(depreciateData.getResult().getCarlist().get(position).getSeriesname());

        }
        holder.specnameTv.setText(depreciateData.getResult().getCarlist().get(position).getSpecname());
        holder.dpriceTv.setText(depreciateData.getResult().getCarlist().get(position).getDealerprice() + "万");
        holder.fctpriceTv.setText(depreciateData.getResult().getCarlist().get(position).getFctprice() + "万");
        //在textview的文本中间加一条横线
        //后一个为清晰显示
        holder.fctpriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);//中间加横线

        double num = (Double.valueOf(depreciateData.getResult().getCarlist().get(position).getFctprice())
                - Double.valueOf(depreciateData.getResult().getCarlist().get(position).getDealerprice()));
        //设置该double型的数字,只取到小数点后两位小数,如果小数点之后
        //没有数字的话,就用数字"0"代替
        String depreciate = new DecimalFormat("####.00").format(num);
        holder.depreciateTv.setText("降" + depreciate + "万");
        holder.cityTv.setText(depreciateData.getResult().getCarlist().get(position).getDealer().getCity());
        holder.shortnameTv.setText(depreciateData.getResult().getCarlist().get(position).getDealer().getShortname());
        holder.distanceTv.setText("距离" + depreciateData.getResult().getCarlist().get(position).getDealer().getDistance());
        holder.orderrangeTv.setText(depreciateData.getResult().getCarlist().get(position).getDealer().getOrderrange());
        Picasso.with(context).load(depreciateData.getResult().getCarlist().get(position).getSpecpic()).
                resize(140, 100).error(R.mipmap.carlogo).into(holder.iconTv);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(depreciateData.getResult().getCarlist().get(position).getDealer().getPhone());
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:"+depreciateData.getResult().getCarlist().get(position).getDealer().getPhone()));
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        context.startActivity(intent);

                    }
                }).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return depreciateData != null ? depreciateData.getResult().getCarlist().size() : 0;
    }


    class DepreciateViewHolder extends RecyclerView.ViewHolder {
        TextView seriesnameTv, specnameTv, dpriceTv, fctpriceTv, depreciateTv,
                cityTv, shortnameTv, distanceTv, orderrangeTv;
        ImageView iconTv;
        LinearLayout call;

        public DepreciateViewHolder(View itemView) {
            super(itemView);
            seriesnameTv = (TextView) itemView.findViewById(R.id.item_depreciate_title_tv);
            specnameTv = (TextView) itemView.findViewById(R.id.item_depreciate_title_right_tv);
            dpriceTv = (TextView) itemView.findViewById(R.id.item_depreciate_price_tv);
            fctpriceTv = (TextView) itemView.findViewById(R.id.item_depreciate_delete_tv);
            cityTv = (TextView) itemView.findViewById(R.id.item_depreciate_diqu_tv);
            shortnameTv = (TextView) itemView.findViewById(R.id.item_depreciate_name_tv);
            distanceTv = (TextView) itemView.findViewById(R.id.item_depreciate_distance_tv);
            orderrangeTv = (TextView) itemView.findViewById(R.id.item_depreciate_sell_tv);
            iconTv = (ImageView) itemView.findViewById(R.id.item_depreciate_icon_iv);
            depreciateTv = (TextView) itemView.findViewById(R.id.item_depreciate_depreciate_tv);
            call = (LinearLayout) itemView.findViewById(R.id.item_depreciate_call_ll);
        }
    }
}
