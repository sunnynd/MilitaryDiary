package com.android.gotoday.home.total;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gotoday.R;
import com.android.gotoday.home.item.DiaryItem;

import java.util.List;

public class TotalRecyclerViewAdapter extends RecyclerView.Adapter<TotalRecyclerViewHolder> {

    private List<DiaryItem> mDiaryItemList;

    public TotalRecyclerViewAdapter(@NonNull List<DiaryItem> diaryItemList) {
        mDiaryItemList = diaryItemList;
    }

    @NonNull
    @Override
    public TotalRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_total,
                parent, false);
        TotalRecyclerViewHolder holder = new TotalRecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TotalRecyclerViewHolder holder, int position) {
        holder.mTitle.setText(mDiaryItemList.get(position).getRecordDate());
    }

    @Override
    public int getItemCount() {
        return mDiaryItemList.size();
    }
}
