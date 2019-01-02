package com.android.gotoday.home.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.gotoday.R;
import com.android.gotoday.common.DateUtil;
import com.android.gotoday.home.item.DiaryItem;

import java.util.ArrayList;
import java.util.List;

public class TodayPagerAdapter extends PagerAdapter {

    private List<DiaryItem> mDiaryItemList = new ArrayList<>();
    private Context mContext;

    public TodayPagerAdapter(Context context, @NonNull List<DiaryItem> diaryItemList) {
        mDiaryItemList.addAll(diaryItemList);
        mDiaryItemList.add(new DiaryItem(DateUtil.getCurrentDate(),null));
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.view_diary, collection, false);

        TextView textViewDate = view.findViewById(R.id.textview_view_diary_date);
        textViewDate.setText(mDiaryItemList.get(position).getRecordDate());

        EditText editText = view.findViewById(R.id.edittext_view_diary);
        editText.setText(mDiaryItemList.get(position).getContents());

        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mDiaryItemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
