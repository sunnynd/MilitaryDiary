package com.android.gotoday.join;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import com.android.gotoday.R;
import com.android.gotoday.common.DateUtil;
import com.android.gotoday.databinding.ActivityJoinBinding;
import com.android.gotoday.home.HomeActivity;

import java.util.Calendar;

public class JoinActivity extends AppCompatActivity {

    ActivityJoinBinding mBinding;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_join);

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
    }
}
