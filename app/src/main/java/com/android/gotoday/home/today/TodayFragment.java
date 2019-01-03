package com.android.gotoday.home.today;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.gotoday.R;
import com.android.gotoday.home.today.TodayPagerAdapter;
import com.android.gotoday.home.item.DiaryItem;
import com.android.gotoday.home.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_base, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewpager_home_today);

        //TODO getDiaryItem in DB ? or Network ?
        List<DiaryItem> dummyDiaryItemList = new ArrayList<>();

        viewPager.setAdapter(new TodayPagerAdapter(getContext(),dummyDiaryItemList));
        viewPager.setCurrentItem(dummyDiaryItemList.size()-1);

        TextView textView = view.findViewById(R.id.textview_base_fragment);
        textView.setText(getText());
        return view;
    }

    @Override
    protected String getText() {
        return "TodayFragment";
    }
}
