package com.android.gotoday.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

import com.android.gotoday.common.DateUtil;

@Database(entities = {PeriodEntry.class}, version=1)
@TypeConverters(DateUtil.class)
public abstract class PeriodDatabase extends RoomDatabase {

    private static final String LOG_TAG = PeriodDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "period";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static PeriodDatabase sInstance;

    public static PeriodDatabase getsInstance(Context context){
        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(), PeriodDatabase.class, PeriodDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Create Database");
            }
        }
        return sInstance;
    }

    public abstract PeriodDao PeriodDao();
}
