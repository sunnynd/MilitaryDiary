package com.android.gotoday.home.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.gotoday.R;

public abstract class BaseFragment extends Fragment {

    protected abstract String getText();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_base, container, false);
        TextView textView = view.findViewById(R.id.textview_base_fragment);
        textView.setText(getText());
        return view;
    }
}
