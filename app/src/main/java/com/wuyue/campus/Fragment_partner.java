package com.wuyue.campus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wuyue.hospitalhelper.R;

import java.util.List;

public class Fragment_partner extends Product_campus {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, null);
        return view;
    }

    @Override
    public List<?> createData() {
        return null;
    }
}
