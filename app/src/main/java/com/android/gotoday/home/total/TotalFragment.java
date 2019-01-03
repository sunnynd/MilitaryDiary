package com.android.gotoday.home.total;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.gotoday.R;
import com.android.gotoday.common.DateUtil;
import com.android.gotoday.home.item.DiaryItem;
import com.android.gotoday.home.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TotalFragment extends BaseFragment {

    private static int SPAN_COUNT_DEFAULT = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_total, container, false);

        TextView textView = view.findViewById(R.id.textview_total_fragment);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_total_fragment);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT_DEFAULT);
        recyclerView.setLayoutManager(gridLayoutManager);

        //TODO get data in DB
        List<DiaryItem> diaryItemList = new ArrayList<>();
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        diaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        TotalRecyclerViewAdapter adapter = new TotalRecyclerViewAdapter(diaryItemList);
        recyclerView.setAdapter(adapter);

        textView.setText(getText());

        return view;
    }

    @Override
    protected String getText() {
        return "ListFragment";
    }
}
