package com.android.gotoday.join;

import android.app.DatePickerDialog;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;

import com.android.gotoday.AppExecutors;
import com.android.gotoday.R;
import com.android.gotoday.common.DateUtil;
import com.android.gotoday.data.database.PeriodDao;
import com.android.gotoday.data.database.PeriodEntry;
import com.android.gotoday.databinding.ActivityJoinBinding;
import com.android.gotoday.home.HomeActivity;

import java.util.Calendar;
import java.util.Date;

public class JoinActivity extends LifecycleActivity {

    private static final String TAG = JoinActivity.class.getSimpleName();

    ActivityJoinBinding mBinding;
    DatePickerDialog datePickerDialog;
    private JoinActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_join);
        mViewModel = ViewModelProviders.of(this).get(JoinActivityViewModel.class);

        mBinding.edittextValueEnterDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(JoinActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                mBinding.edittextValueEnterDate.setText(DateUtil.getStringDateFormat(year, month, day));
                            }
                        }, 0, 0, 0);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        mBinding.cardviewJoinFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mBinding.spinnerValueGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, String.valueOf(i));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
            }
        );

        mViewModel.getPeriod().observe(this, periodEntry -> {
            if (periodEntry != null) {

            }
        });

        AppExecutors.getInstance().diskIO().execute(()-> {
            try {
                // Pretend this is the network loading data
                Thread.sleep(4000);
                Date today = DateUtil.getNormalizedUtcDateForToday();
                PeriodEntry pretendPeriodFromDatabase = new PeriodEntry(1,"Army", 365);
                mViewModel.setPeriod(pretendPeriodFromDatabase);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
