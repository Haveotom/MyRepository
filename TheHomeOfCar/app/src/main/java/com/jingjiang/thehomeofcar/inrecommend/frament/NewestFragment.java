package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.Request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.BuildConfig;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.bean.inrecommend.NewestData;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;
import com.jingjiang.thehomeofcar.widget.GsonRequest;
import com.jingjiang.thehomeofcar.widget.MyRequestQueue;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;


/**
 * Created by dllo on 16/5/9.
 */
public class NewestFragment extends BaseFragment  {
    private NewestAdapter newestAdapter;
    private RecyclerView recyclerView;
    //轮播图
    private ViewPager viewPager;
    private LinearLayout layout;//放点的布局
    private int currentIndex = 300;//当前页面下标
//    private NewestRecycleAdapter newestRecycleAdapter;
    private Long lastTime = System.currentTimeMillis();//获取系统当前时间
    private Handler handler = new Handler();
    private List<NewestData> newestDataList;
    private NewestData newestData;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //主线程
            if ((System.currentTimeMillis() - lastTime) > 3000) {
                currentIndex++;
                viewPager.setCurrentItem(currentIndex);//
                lastTime = System.currentTimeMillis();//更新时间
            }
            handler.postDelayed(runnable, 3000);//延迟3秒
        }
    };

    @Override
    public int initLayout() {
        return R.layout.recommend_f_newest;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.newest_rv);
        RecyclerViewHeader header = bindView(R.id.newest_header_rv);
        newestAdapter = new NewestAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        header.attachTo(recyclerView);

        //轮播图适配器
        viewPager = bindView(R.id.newest_viewpager);
        layout = bindView(R.id.newest_linearlayout);
//        newestRecycleAdapter = new NewestRecycleAdapter();


    }

    @Override
    public void initData() {
        GsonRequest<NewestData> newestDataGsonRequest = new GsonRequest<>(Request.Method.GET,
                "http://app.api.autohome.com.cn/autov4.2.5/news/newslist-a2-pm1-v4.2.5-c0-nt0-p1-s30-l0.html",
                new Response.ErrorListener() {//失败
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<NewestData>() {//成功

            @Override
            public void onResponse(NewestData response) {
                newestAdapter.setNewestData(response);
//                newestRecycleAdapter.setNewestData(response);
            }
        }, NewestData.class);
        MyRequestQueue.getRequestQueue().add(newestDataGsonRequest);
        recyclerView.setAdapter(newestAdapter);

        //小圆点
        //添加图片地址


//        for (int i = 0; i < image.size(); i++) {
//            ImageView point = new ImageView(getContext());
//            point.setImageResource(R.mipmap.no);
//            layout.addView(point);
//        }
        //初始化适配器
//        viewPager.setAdapter(newestRecycleAdapter);
        //设置当前view
        viewPager.setCurrentItem(300);
//        viewPager.setOnPageChangeListener(this);
        //延时开启线程
        handler.postDelayed(runnable, 3000);

//        轮播图加载数据

    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        handler.removeCallbacks(runnable);
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        currentIndex = position;
//        int index = position % newestData.getResult().getFocusimg().size();
//        //自定义方法,设置小圆点
//        setCurrentSelected(index);
//        lastTime = System.currentTimeMillis();
//
//    }
//
//    //小圆点
//    private void setCurrentSelected(int currentIndex) {
//        for (int i = 0; i < layout.getChildCount(); i++) {
//            ImageView child = (ImageView) layout.getChildAt(i);//设置每一个小圆点
//            if (i == currentIndex) {
//                child.setImageResource(R.mipmap.yes);
//            } else {
//                child.setImageResource(R.mipmap.no);
//            }
//        }
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }


    //    轮播图
//    public class NewestRecycleAdapter extends PagerAdapter {
//        private NewestData newestData;
//        int index;
//        List<NewestData> newestDataList;
//
//        public void setNewestDataList(List<NewestData> newestDataList) {
//            this.newestDataList = newestDataList;
//            notifyDataSetChanged();
//        }
//
//        public void setNewestData(NewestData newestData) {
//            this.newestData = newestData;
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public int getCount() {
//            //返回最大值 使用户看不到边界
//            return Integer.MAX_VALUE;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            ImageView iconIv = bindView(R.id.newest_icon);
//            //需要循环才能确定当前页
//            index = position % newestData.getResult().getFocusimg().size();
//            //添加图片
//            Picasso.with(getContext()).load(newestData.getResult().getFocusimg().get(position).getImgurl()).into(iconIv);
//            container.addView(iconIv);
//            return newestData.getResult().getFocusimg().get(index);
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//        }
//    }
}
