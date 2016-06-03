package com.jingjiang.thehomeofcar.inrecommend.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.MyApplication;
import com.jingjiang.thehomeofcar.bean.inrecommend.FastReportDetailData;
import com.jingjiang.thehomeofcar.inindividual.LoginAty;
import com.jingjiang.thehomeofcar.widget.NoScrollListView;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * Created by dllo on 16/5/24.
 */
public class FastReportDetailAdapter extends RecyclerView.Adapter<FastReportDetailAdapter.FastReportDetailViewHolder> implements View.OnClickListener {
    private FastReportDetailData detailData;
    private Context context;

    public FastReportDetailAdapter(Context context) {
        this.context = context;
    }

    public void setDetailData(FastReportDetailData detailData) {
        this.detailData = detailData;
        notifyDataSetChanged();
    }

    @Override
    public FastReportDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fastreport_content, parent, false);
        FastReportDetailViewHolder holder = new FastReportDetailViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FastReportDetailViewHolder holder, final int position) {
        holder.authorTv.setText(detailData.getResult().getMessagelist().get(position).getAuthorname());
        holder.timeTv.setText(detailData.getResult().getMessagelist().get(position).getPublishtime() + "");
        holder.contentTv.setText(detailData.getResult().getMessagelist().get(position).getContent());

        holder.upcountTv.setText(detailData.getResult().getMessagelist().get(position).getUpcount() + "");
        holder.replycountTv.setText(detailData.getResult().getMessagelist().get(position).getReplycount() + "");
        Picasso.with(context).load(detailData.getResult().getMessagelist().get(position).getHeadimg())
                .error(R.mipmap.carlogo).resize(70, 70).into(holder.authorHeaderIv);
        //分享的跳转
        holder.shareLl.setOnClickListener(this);
        holder.zanLl.setOnClickListener(this);

        holder.listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return detailData != null ?
                        detailData.getResult().getMessagelist().get(position).getCommentlist().size() : 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int pos, View convertView, ViewGroup parent) {
                ViewHolder holder = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).
                            inflate(R.layout.item_fastreport_content_detail, parent, false);
                    holder = new ViewHolder(convertView);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.usernameTv.setText(
                        detailData.getResult().getMessagelist().get(position).
                                getCommentlist().get(pos).getUsername());
                holder.contentTv.setText(detailData.getResult().getMessagelist().get(position)
                        .getCommentlist().get(pos).getContent());
                if (detailData.getResult().getMessagelist().get(position).getCommentlist().get(pos).getHeadimg() == "") {
                    holder.headIv.setImageResource(R.mipmap.people);
                } else {
                    Picasso.with(context).load(detailData.getResult().getMessagelist().
                            get(position).getCommentlist().get(pos).getHeadimg()).resize(45, 45)
                            .error(R.mipmap.carlogo).into(holder.headIv);
//
                }


                return convertView;
            }

            class ViewHolder {
                TextView usernameTv, contentTv;
                ImageView headIv;

                public ViewHolder(View itemView) {
                    usernameTv = (TextView) itemView.findViewById(R.id.item_content_detail_username);
                    contentTv = (TextView) itemView.findViewById(R.id.item_content_detail_content);
                    headIv = (ImageView) itemView.findViewById(R.id.item_content_detail_head);

                }
            }
        });
        //图片的ListView
        if (detailData.getResult().getMessagelist().get(position).getAttachments() != null) {
            //给图片设置listview
            //继承自baseadapter
            holder.pictureLv.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return detailData != null ? detailData.getResult().getMessagelist().get(position).getAttachments().size() : 0;
                }

                @Override
                public Object getItem(int position) {
                    return null;
                }

                @Override
                public long getItemId(int position) {
                    return 0;
                }

                @Override
                public View getView(int pos, View convertView, ViewGroup parent) {
                    ViewHolder holder = null;
                    if (convertView == null) {
                        convertView = LayoutInflater.from(context).
                                inflate(R.layout.item_fastreport_content_picture, parent, false);
                        holder = new ViewHolder(convertView);
                        convertView.setTag(holder);
                    } else {
                        holder = (ViewHolder) convertView.getTag();
                    }
                    Picasso.with(context).load(
                            detailData.getResult().getMessagelist().get(position).getAttachments().get(pos).getPicurl())
                            .resize(detailData.getResult().getMessagelist().get(position).getAttachments().get(pos).getWidth(),
                                    detailData.getResult().getMessagelist().get(position).getAttachments().get(pos).getHeight())
                            .into(holder.pictureIv);

                    return convertView;
                }

                class ViewHolder {
                    ImageView pictureIv;
                    public ViewHolder(View itemView) {
                        pictureIv = (ImageView) itemView.findViewById(R.id.item_picture_iv);

                    }
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return detailData != null ? detailData.getResult().getMessagelist().size() : 0;
    }

    //各个跳转的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_f_ll_fenxiang:
                Intent intent = new Intent(context, LoginAty.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            case R.id.item_f_ll_zan:
                Intent intentZ = new Intent(context, LoginAty.class);
                intentZ.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentZ);
                break;
        }

    }

    class FastReportDetailViewHolder extends RecyclerView.ViewHolder {
        TextView authorTv, timeTv, contentTv, upcountTv, replycountTv;
        ImageView authorHeaderIv;
        NoScrollListView listView, pictureLv;
        EditText editText;
        LinearLayout shareLl, zanLl;


        public FastReportDetailViewHolder(View itemView) {
            super(itemView);
            authorTv = (TextView) itemView.findViewById(R.id.item_f_content_author);
            timeTv = (TextView) itemView.findViewById(R.id.item_f_content_time);
            contentTv = (TextView) itemView.findViewById(R.id.item_f_content_content);
            upcountTv = (TextView) itemView.findViewById(R.id.item_f_content_upcount);
            replycountTv = (TextView) itemView.findViewById(R.id.item_f_content_replycount);
            authorHeaderIv = (ImageView) itemView.findViewById(R.id.item_f_content_head);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_f_content_recyclerview);
            editText = (EditText) itemView.findViewById(R.id.item_f_content_edit_et);
            shareLl = (LinearLayout) itemView.findViewById(R.id.item_f_ll_fenxiang);
            pictureLv = (NoScrollListView) itemView.findViewById(R.id.item_f_content_allpicture_ll);
            zanLl = (LinearLayout) itemView.findViewById(R.id.item_f_ll_zan);

        }
    }

}
