package com.android.gotoday.home;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.gotoday.R;
import com.android.gotoday.databinding.ActivityHomeBinding;
import com.android.gotoday.home.view.ProfileFragment;
import com.android.gotoday.home.today.TodayFragment;
import com.android.gotoday.home.total.TotalFragment;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_main_view, new TodayFragment());
        fragmentTransaction.commit();

        mBinding.containerHomeTap.textviewHomeTapList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_main_view, new TotalFragment());
                fragmentTransaction.commit();
            }
        });

        mBinding.containerHomeTap.textviewHomeTapToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_main_view, new TodayFragment());
                fragmentTransaction.commit();
            }
        });

        mBinding.containerHomeTap.textviewHomeTapProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_main_view, new ProfileFragment());
                fragmentTransaction.commit();
            }
        });
    }
}
