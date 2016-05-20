package com.jingjiang.thehomeofcar.infindcar.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.jingjiang.thehomeofcar.R;
import com.jingjiang.thehomeofcar.base.BaseFragment;
import com.jingjiang.thehomeofcar.infindcar.adapter.SecondCarAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/10.
 * http://m.che168.com/handler/carlist/getcarlist.ashx?rand=2012&area=dalian&brand=&ls=&spec=&minPrice=0&maxPrice=0&minRegisteAge=0&maxRegisteAge=0&MileageId=0&disp=&stru=&gb=0&color=&source=&listview=0&sell=1&newCar=0&credit=0&sort=0&extrepair=0&page=1&ex=cd0t0p0w0ru0e0sa0o0i0g0nfzlk0v0a0m0_0xb0y0&sourcename=mainapp
 */

//http://m.che168.com/handler/carlist/getcarlist.ashx?rand=2012&area=dalian&brand=&ls=&spec=&minPrice=0&maxPrice=0&minRegisteAge=0&maxRegisteAge=0&MileageId=0&disp=&stru=&gb=0&color=&source=&listview=0&sell=1&newCar=0&credit=0&sort=0&extrepair=0&page=2&ex=cd0t0p0w0ru0e0sa0o0i0g0nfzlk0v0a0m0_0xb0y0&sourcename=mainapp HTTP/1.1
public class SecondCarFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private RecyclerViewHeader header;
    private SecondCarAdapter secondCarAdapter;
    private List<String> list;

    @Override
    public int initLayout() {
        return R.layout.findcar_f_secondcar;
    }

    @Override
    public void initView() {
        recyclerView = bindView(R.id.secondcar_rv);
        header = bindView(R.id.secondcar_header_rv);
        secondCarAdapter = new SecondCarAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(" " + i);
        }
        secondCarAdapter.setList(list);

        header.attachTo(recyclerView);
        recyclerView.setAdapter(secondCarAdapter);


    }

    @Override
    public void initData() {

    }
}
