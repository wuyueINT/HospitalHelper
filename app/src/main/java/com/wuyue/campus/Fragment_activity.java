package com.wuyue.campus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.hospitalhelper.R;

import java.util.List;

public class Fragment_activity extends Product_campus {

    private TextView tv_bangdan;
    private XRecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, null);
        //tv_bangdan = view.findViewById(R.id.tv_bangdan);
        //recyclerView = view.findViewById(R.id.recycler_activity);


        return view;
    }

    @Override
    public List<?> createData() {
        return null;
    }
}
