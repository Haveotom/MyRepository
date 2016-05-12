package com.jingjiang.thehomeofcar.inforum.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.inrecommend.adapter.NewestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 */
public class WellSelectionFragment extends BaseFragment {
    private NewestAdapter newestAdapter;
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.forum_f_wellselection;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.wellselection_rv);
        newestAdapter = new NewestAdapter(getContext());
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("luntan" + i);
        }
//        newestAdapter.setData(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newestAdapter);

    }

    @Override
    public void initData() {

    }
}
