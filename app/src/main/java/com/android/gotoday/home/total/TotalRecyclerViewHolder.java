package com.android.gotoday.home.total;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.gotoday.R;

public class TotalRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mTitle;

    public TotalRecyclerViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.textview_viewhoholder_total_title);
    }
}
