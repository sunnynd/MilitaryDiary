package com.android.gotoday.home.item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryItem {
    Date mRecordDate;
    String mContents;

    public DiaryItem(Date recordDate, String contents) {
        mRecordDate = recordDate;
        mContents = contents;
    }

    public String getRecordDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(mRecordDate);
    }

    public String getContents() {
        return mContents;
    }
}
