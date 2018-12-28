package com.android.gotoday.join;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.gotoday.R;
import com.android.gotoday.databinding.ActivityJoinBinding;
import com.android.gotoday.home.HomeActivity;

public class JoinActivity extends AppCompatActivity {

    ActivityJoinBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_join);
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
