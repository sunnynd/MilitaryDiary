package com.android.gotoday.home.item;

public class DiaryItem {
    String mRecordDate;
    String mContents;

    public DiaryItem(String recordDate, String contents) {
        mRecordDate = recordDate;
        mContents = contents;
    }

    public String getRecordDate() {
        return mRecordDate;
    }
}
