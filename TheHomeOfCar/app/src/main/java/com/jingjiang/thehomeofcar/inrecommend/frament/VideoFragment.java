package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inrecommend.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/9.
 */
public class VideoFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;

    @Override
    public int initLayout() {
        return R.layout.recommend_f_video;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.video_rv);
        videoAdapter = new VideoAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("视频" + i);
        }
        videoAdapter.setData(data);
        recyclerView.setAdapter(videoAdapter);


    }

    @Override
    public void initData() {

    }
}
