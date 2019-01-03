package com.android.gotoday.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.Date;

@Dao
public interface PeriodDao {
    @Query("SELECT * FROM military_period WHERE groupType = :group")
    PeriodEntry getPeriodByGroup(String group);
}
