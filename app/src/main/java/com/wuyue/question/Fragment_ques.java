package com.wuyue.question;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wuyue.hospitalhelper.R;

import java.util.List;

public class Fragment_ques extends Product {

    private EditText ed_question;
    private EditText ed_content;
    private Button btn_add;
    private EditText ed_section;
    private EditText ed_keyword;
    private Button btn_permission;
    private Button btn_unwatched;
    private EditText ed_reward;
    private EditText ed_timelimit;
    private Button btn_upload;

    private int permission = 0; //未选中仅限医生作答
    private int unwatched = 0; //未选中匿名

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ques, null);
        ed_question = view.findViewById(R.id.ed_question);
        ed_content = view.findViewById(R.id.ed_content);
        btn_add = view.findViewById(R.id.btn_add);
        ed_section = view.findViewById(R.id.ed_section);
        ed_keyword = view.findViewById(R.id.ed_keyword);
        btn_permission = view.findViewById(R.id.btn_permission);
        btn_upload = view.findViewById(R.id.btn_upload);
        btn_unwatched = view.findViewById(R.id.btn_unwatched);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加图片功能
                Toast.makeText(getActivity(), "添加图片", Toast.LENGTH_SHORT).show();
            }
        });

        btn_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (permission==0){
                    permission = 1;
                } else if (permission==1){
                    permission = 0;
                }
                Toast.makeText(getActivity(), permission+"", Toast.LENGTH_SHORT).show();
            }
        });

        btn_unwatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unwatched==0){
                    unwatched = 1;
                } else if (unwatched==1){
                    unwatched = 0;
                }
                Toast.makeText(getActivity(), unwatched+"", Toast.LENGTH_SHORT).show();
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交所填信息
                Toast.makeText(getActivity(), "将信息提交", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public List<?> createData() {
        return null;
    }
}
