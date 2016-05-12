package com.jingjiang.thehomeofcar.inforum.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inforum.adapter.HotPostAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class HotPostFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private HotPostAdapter hotPostAdapter;

    @Override
    public int initLayout() {
        return R.layout.forum_f_hotpost;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.hotpost_rv);
        RecyclerViewHeader header = bindView(R.id.hotpost_header_rv);
        hotPostAdapter = new HotPostAdapter(getContext());
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("Hot" + i);
        }
        hotPostAdapter.setData(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        header.attachTo(recyclerView);
        recyclerView.setAdapter(hotPostAdapter);

    }

    @Override
    public void initData() {

    }
}
