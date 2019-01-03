package com.android.gotoday.data.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "military_period")
public class PeriodEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String groupType;
    private int period;

    public PeriodEntry(int id, String groupType, int period) {
        this.id = id;
        this.groupType = groupType;
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public String getGroupType() {
        return groupType;
    }

    public int getPeriod() {
        return period;
    }
}