package com.jingjiang.thehomeofcar.inrecommend.frament;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/5/9.
 */
public class NewestFragment extends BaseFragment {
    private NewestAdapter newestAdapter;
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.recommend_f_newest;
    }

    @Override
    public void initView() {

        recyclerView = bindView(R.id.newest_rv);
        RecyclerViewHeader header = bindView(R.id.newest_header_rv);
        newestAdapter = new NewestAdapter(getContext());
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("Something" + i);
        }
        newestAdapter.setData(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        header.attachTo(recyclerView);
        recyclerView.setAdapter(newestAdapter);

    }

    @Override
    public void initData() {

    }
}
