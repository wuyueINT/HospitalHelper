package com.wuyue.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.hospitalhelper.DoctorLog;
import com.wuyue.hospitalhelper.R;
import com.wuyue.hospitalhelper.RecyclerAdapter_focus;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends AppCompatActivity {

    private LinearLayout ll_label;
    private TextView tv_content;
    private Button btn_ans;
    private Button btn_like;
    private XRecyclerView recyclerView;
    private TextView tv_ansnum;
    private RecyclerAdapter_focus adapter;

    String[] labels;
    String question;
    String ansnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_answer);

        initView();

        initData();

        tv_content.setText(question);
        String s = "回答  "+ansnum;
        tv_ansnum.setText(s);

        for (int i=0; i<labels.length; i++){
            if (i>=3) break;

            View view = LayoutInflater.from(this).inflate(R.layout.label, null);
            com.foxmail.aroundme.library.LabelTextView tv_label = view.findViewById(R.id.tv_label);

            tv_label.setLabelText(labels[i]);
            ll_label.addView(tv_label);
        }

        btn_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnswerActivity.this, "回答该问题", Toast.LENGTH_SHORT).show();
            }
        });

        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnswerActivity.this, "关注该问题", Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new RecyclerAdapter_focus(this, createData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initData() {

        Intent intent = getIntent();
        labels = intent.getStringArrayExtra("labels");
        question = intent.getStringExtra("question");
        ansnum = intent.getStringExtra("ansnum");
    }

    private void initView() {

        ll_label = findViewById(R.id.ll_label);
        tv_content = findViewById(R.id.tv_content);
        btn_ans = findViewById(R.id.btn_ans);
        btn_like = findViewById(R.id.btn_like);
        recyclerView = findViewById(R.id.recycler_otherans);
        tv_ansnum = findViewById(R.id.tv_ansnum);
    }


    private List<DoctorLog> createData(){
        List<DoctorLog> doctorLogs = new ArrayList<>();
        Bitmap default_photo = BitmapFactory.decodeResource(getResources(), R.drawable.default_photo);

        //创建三个备用
        DoctorLog doctorLog1 = new DoctorLog();
        doctorLog1.setBitmap(default_photo);
        doctorLog1.setName("吴丽");
        doctorLog1.setDate("2020.5.18");
        doctorLog1.setPro("山大二院口腔主治");
        doctorLog1.setLog("正畸效果展示");
        doctorLogs.add(doctorLog1);

        DoctorLog doctorLog2 = new DoctorLog();
        doctorLog2.setBitmap(default_photo);
        doctorLog2.setName("刘双全");
        doctorLog2.setDate("2020.3.6");
        doctorLog2.setPro("山大二院骨科主任");
        doctorLog2.setLog("昨天门诊遇到一桡骨远端……");
        doctorLogs.add(doctorLog2);

        DoctorLog doctorLog3 = new DoctorLog();
        doctorLog3.setBitmap(default_photo);
        doctorLog3.setName("刘来奇");
        doctorLog3.setDate("2020.3.5");
        doctorLog3.setLog("牙齿矫正过程中……");
        doctorLogs.add(doctorLog3);

        for (int i=0; i<10; i++){
            doctorLogs.add(doctorLog3);
        }
        doctorLogs.add(doctorLog2);
        doctorLogs.add(doctorLog1);

        return doctorLogs;
    }
}
