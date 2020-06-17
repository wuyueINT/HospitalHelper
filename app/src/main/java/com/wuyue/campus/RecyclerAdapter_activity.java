package com.wuyue.campus;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class RecyclerAdapter_activity extends XRecyclerView.Adapter<RecyclerAdapter_activity.VH> {


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class VH extends RecyclerView.ViewHolder {


        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
