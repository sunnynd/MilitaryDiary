package com.android.gotoday.home.item;

import com.android.gotoday.R;

public enum DiaryItem {

    FIRST(R.layout.view_diary, "FIRST"),
    SECOND(R.layout.view_diary, "SECOND"),
    THIRD(R.layout.view_diary, "THIRD");

    private int mLayoutResId;
    private String mTitle;

    DiaryItem(int layoutResId, String title) {
        mLayoutResId = layoutResId;
        mTitle = title;
    }

    public int getlayoutResId() {
        return mLayoutResId;
    }

    public String getTitle() {
        return mTitle;
    }
}
