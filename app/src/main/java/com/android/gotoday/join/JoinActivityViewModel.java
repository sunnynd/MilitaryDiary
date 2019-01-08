package com.android.gotoday.join;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.gotoday.data.database.PeriodEntry;

public class JoinActivityViewModel extends ViewModel {

    private MutableLiveData<PeriodEntry> mPeriod;

    public JoinActivityViewModel() {
        mPeriod = new MutableLiveData<>();
    }

    public MutableLiveData<PeriodEntry> getPeriod() {
        return mPeriod;
    }

    public void setPeriod(PeriodEntry period) {
        mPeriod.setValue(period);
    }
}
