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
        /**
         * rowcount : 281
         * isloadmore : true
         * list : [{
         * "id":309,
         * "title":"科技前卫！亚洲CES展快报",
         * "reviewcount":62620,
         * "img":"http://www2.autoimg.cn/newsdfs/g16/M00/73/C4/1024x768_0_autohomecar__wKgH5lctTw2AL3Z1AANsn81UI2w023.jpg",
         * "bgimage":"http://www2.autoimg.cn/newsdfs/g16/M13/73/8C/1024x512_0_autohomecar__wKjBx1ctTwuAMmaRAAI-ReHh1jQ977.jpg",
         * "typeid":4,
         * "typename":"其他快报",
         * "state":2,
         * "createtime":"2016-05-12",
         * "advancetime":"2016-05-12",
         * "publishtiptime":"1463017016",
         * "lastid":"201605120936560002309"},{"id":312,"title":"道路试驾 马自达CX-4快报","reviewcount":1341798,"img":"http://www3.autoimg.cn/newsdfs/g14/M07/7A/07/1024x768_0_autohomecar__wKgH5Fcy5fyAYxxlAAQHyYIAdFM458.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g17/M0A/73/BE/1024x512_0_autohomecar__wKjBxlcy5iGAcCT_AALCWh5ghlw475.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-05-11","advancetime":"2016-05-11","publishtiptime":"1462929235","lastid":"201605110913550002312"},{"id":308,"title":"北汽绅宝X35驾驶体验","reviewcount":134948,"img":"http://www2.autoimg.cn/newsdfs/g8/M10/68/E4/1024x768_0_autohomecar__wKjBz1cps5OAPAwlAAM4xy5yCKA278.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g22/M0D/52/53/1024x512_0_autohomecar__wKjBwVcps9CAFk-CAAO2EDrdOLY320.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-05-11","advancetime":"2016-05-11","publishtiptime":"1462929169","lastid":"201605110912490002308"},{"id":311,"title":"配置升级 试驾新款骐达","reviewcount":419298,"img":"http://www3.autoimg.cn/newsdfs/g8/M14/6F/8B/1024x768_0_autohomecar__wKjBz1cwYOmAaxiXAAbyo7IBoVQ858.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g6/M08/76/9D/1024x512_0_autohomecar__wKgH3FcwNf6AB-H5AASegTk_8Ww450.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-05-09","advancetime":"2016-05-09","publishtiptime":"1462788297","lastid":"201605091804570002311"},{"id":310,"title":"MINI敞篷版试驾快报","reviewcount":133810,"img":"http://www2.autoimg.cn/newsdfs/g10/M0F/75/AF/1024x768_0_autohomecar__wKgH0VcvUk2ACwSsAAbNFDKcmm8698.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g10/M11/75/F7/1024x512_0_autohomecar__wKgH4FcvUkWAIRAsAATM7FHBVHw324.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-05-09","advancetime":"2016-05-09","publishtiptime":"1462756466","lastid":"201605090914260002310"},{"id":306,"title":"一汽吉林森雅R7上市快报","reviewcount":742729,"img":"http://www3.autoimg.cn/newsdfs/g13/M03/67/FC/1024x768_0_autohomecar__wKgH41cgmCiAf2n0AANeRacD5Bs179.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g13/M11/67/5F/1024x512_0_autohomecar__wKjBylcgmCSAQQ9mAAJzWV9bBOc634.jpg","typeid":2,"typename":"首发/上市快报","state":2,"createtime":"2016-04-27","advancetime":"2016-04-27","publishtiptime":"1461753655","lastid":"201604271840550002306"},{"id":307,"title":"机械迷必看！汉诺威工业展","reviewcount":358665,"img":"http://www3.autoimg.cn/newsdfs/g23/M06/49/3E/1024x768_0_autohomecar__wKgFV1cgWZeAJ1lSAAVpBRfVAgA149.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g21/M06/48/50/1024x512_0_autohomecar__wKgFVVcgWVqAAbBDAAQIRkqdXLk596.jpg","typeid":4,"typename":"其他快报","state":2,"createtime":"2016-04-27","advancetime":"2016-04-27","publishtiptime":"1461740791","lastid":"201604271506310002307"},{"id":304,"title":"大众之夜5款全新车型首发","reviewcount":1999449,"img":"http://www2.autoimg.cn/newsdfs/g10/M14/62/AE/1024x768_0_autohomecar__wKgH0VccxmKABS9hAAHLEpynAnI553.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g10/M08/63/0E/1024x512_0_autohomecar__wKgH4Fccxl-ACtkpAAFsC-5jnBM098.jpg","typeid":1,"typename":"车展快报","state":2,"createtime":"2016-04-24","advancetime":"2016-04-24","publishtiptime":"1461496669","lastid":"201604241917490002304"},{"id":303,"title":"新奔驰E级长轴距首发快报","reviewcount":980158,"img":"http://www3.autoimg.cn/newsdfs/g15/M05/63/FF/1024x768_0_autohomecar__wKgH1lccuZyALBTnAAXd3skJM5E887.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g15/M02/60/8C/1024x512_0_autohomecar__wKgH5VccuZSAcHlyAARO27kEsw8293.jpg","typeid":1,"typename":"车展快报","state":2,"createtime":"2016-04-24","advancetime":"2016-04-24","publishtiptime":"1461493639","lastid":"201604241827190002303"},{"id":305,"title":"马自达CX-4全球首发快报","reviewcount":835117,"img":"http://www3.autoimg.cn/newsdfs/g15/M06/60/A5/1024x768_0_autohomecar__wKgH5VccySKAC3PJAAHyna7g0ms586.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g17/M0B/5D/89/1024x512_0_autohomecar__wKjBxlccyVOAe0peAAGbkedjcMI993.jpg","typeid":1,"typename":"车展快报","state":2,"createtime":"2016-04-24","advancetime":"2016-04-24","publishtiptime":"1461488490","lastid":"201604241701300002305"},{"id":299,"title":"新车多！北京车展探馆快报","reviewcount":1558920,"img":"http://www3.autoimg.cn/newsdfs/g5/M0F/5F/4C/1024x768_0_autohomecar__wKjB0lcZpyOAUHkoAAXDmloDzT8198.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g5/M0B/5F/97/1024x512_0_autohomecar__wKgHzFcZpx2AHMNwAASpUqrP8Nw117.jpg","typeid":1,"typename":"车展快报","state":2,"createtime":"2016-04-24","advancetime":"2016-04-24","publishtiptime":"1461480331","lastid":"201604241445310002299"},{"id":301,"title":"北京80/40L/新款40上市","reviewcount":735983,"img":"http://www2.autoimg.cn/newsdfs/g23/M14/44/79/1024x768_0_autohomecar__wKgFXFcbZRaAK_TSAAnSr3ctF9g690.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g23/M0D/44/3B/1024x512_0_autohomecar__wKgFV1cbZRGABBSlAAZQrKeqTzI784.jpg","typeid":2,"typename":"首发/上市快报","state":2,"createtime":"2016-04-23","advancetime":"2016-04-23","publishtiptime":"1461409368","lastid":"201604231902480002301"},{"id":300,"title":"广汽本田之夜多款新车首发","reviewcount":1394423,"img":"http://www3.autoimg.cn/newsdfs/g19/M0D/43/CC/1024x768_0_autohomecar__wKjBxFcbeQuALE7uAANvQYDu0hE953.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g19/M02/43/F5/1024x512_0_autohomecar__wKgFWFcbeQWAat9zAAJ4srGjdaY073.jpg","typeid":2,"typename":"首发/上市快报","state":2,"createtime":"2016-04-23","advancetime":"2016-04-23","publishtiptime":"1461409311","lastid":"201604231901510002300"},{"id":302,"title":"福特之夜五款新车型将首发","reviewcount":1123767,"img":"http://www2.autoimg.cn/newsdfs/g4/M11/60/F5/1024x768_0_autohomecar__wKjB01cbLPeAYFRqAAL6Fj74OYc763.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g17/M0D/5C/39/1024x512_0_autohomecar__wKjBxlcbbHOAFzM-AAaKYR42w54063.jpg","typeid":2,"typename":"首发/上市快报","state":2,"createtime":"2016-04-23","advancetime":"2016-04-23","publishtiptime":"1461407891","lastid":"201604231838110002302"},{"id":298,"title":"纯电动汽车绿色驾驶体验会","reviewcount":225744,"img":"http://www2.autoimg.cn/newsdfs/g23/M09/42/47/1024x768_0_autohomecar__wKgFV1cZiD-ADs0bAAIUW4uDdqU902.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g23/M09/42/6C/1024x512_0_autohomecar__wKjBwFcZiDyAN6cOAAUntGsTPCw657.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-04-23","advancetime":"2016-04-23","publishtiptime":"1461368402","lastid":"201604230740029202298"},{"id":296,"title":"哈弗H7试驾快报","reviewcount":1866989,"img":"http://www3.autoimg.cn/newsdfs/g12/M0C/57/F4/1024x768_0_autohomecar__wKjBy1cQohGAKW1jAAObi_DHf9c134.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g11/M05/56/4F/1024x512_0_autohomecar__wKjBzFcQogiAAl8cAANW60xLy6I608.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-04-18","advancetime":"2016-04-18","publishtiptime":"1460943373","lastid":"201604180936137272296"},{"id":293,"title":"一汽吉林森雅R7试驾快报","reviewcount":616299,"img":"http://www3.autoimg.cn/newsdfs/g16/M06/59/98/1024x768_0_autohomecar__wKgH11cTe9KAdzKOAAcD83SgTFI397.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g16/M10/59/C5/1024x512_0_autohomecar__wKgH5lcTe8mAUG3RAAT8snpIvXE860.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-04-16","advancetime":"2016-04-16","publishtiptime":"1460769028","lastid":"201604160910280002293"},{"id":294,"title":"玛莎拉蒂Levante试驾快报","reviewcount":823731,"img":"http://www2.autoimg.cn/newsdfs/g11/M01/5B/FC/1024x768_0_autohomecar__wKgH0lcV1n6AYE0wAA0WibdCKLs253.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g9/M00/5B/BC/1024x512_0_autohomecar__wKgH0FcV1neAGUCoAAkbuzoTERY155.jpg","typeid":2,"typename":"首发/上市快报","state":2,"createtime":"2016-04-15","advancetime":"2016-04-15","publishtiptime":"1460707200","lastid":"201604151600000002294"},{"id":295,"title":"广汽传祺GA8试驾快报","reviewcount":473450,"img":"http://www2.autoimg.cn/newsdfs/g16/M05/56/2D/1024x768_0_autohomecar__wKgH11cPx_iARa9SAAIevmqIKZc849.jpg","bgimage":"http://www2.autoimg.cn/newsdfs/g22/M06/39/14/1024x512_0_autohomecar__wKgFVlcPySWAdztZAAS7H7V4Mk4869.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-04-15","advancetime":"2016-04-15","publishtiptime":"1460691319","lastid":"201604151135190002295"},{"id":292,"title":"试驾大众蔚揽旅行车快报","reviewcount":1089647,"img":"http://www3.autoimg.cn/newsdfs/g14/M0C/52/47/1024x768_0_autohomecar__wKgH1VcNAluAUC8LAAdtWs_EZWs840.jpg","bgimage":"http://www3.autoimg.cn/newsdfs/g14/M0B/52/46/1024x512_0_autohomecar__wKgH1VcNAlaAPn9zAAS4pWX8f6s633.jpg","typeid":3,"typename":"试驾评测快报","state":2,"createtime":"2016-04-13","advancetime":"2016-04-13","publishtiptime":"1460507023","lastid":"201604130823430002292"}]
         */

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
