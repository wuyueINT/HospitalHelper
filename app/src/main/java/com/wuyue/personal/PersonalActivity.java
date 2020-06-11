package com.wuyue.personal;

/**
 * 他人的个人主页部分
 *
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuyue.hospitalhelper.DoctorLog;
import com.wuyue.hospitalhelper.R;

import java.util.ArrayList;
import java.util.List;

public class PersonalActivity extends AppCompatActivity {

    private ImageView mHead;
    private TextView tv_personal_fans;
    private TextView tv_personal_profession;
    private Button btn1; //个人介绍页面
    private Button btn2; //发布内容
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter adapter;
    private List<DoctorLog> doctorLogs;
    private List<String> urls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        initData();

        adapter = new RecyclerAdapter_personal(this, doctorLogs, urls);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    //创建模拟数据
    private void initData() {

        doctorLogs = new ArrayList<>();
        Bitmap default_photo = BitmapFactory.decodeResource(getResources(), R.drawable.default_photo);

        mHead.setImageBitmap(default_photo);
        tv_personal_fans.setText("收藏1  粉丝1");
        tv_personal_profession.setText("认证 山大二院口腔科医师");

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

        urls = new ArrayList<>();
        addURLToList(urls);

    }

    //从百度下载图片加入到容器中
    private void addURLToList(List<String> urls) {

        String url = "https://t7.baidu.com/it/u=3616242789,1098670747&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1591777798&t=3d70fee5da43203ecc265e3b73ce87a0";
        for (int i=0; i<(int)(Math.random()*6); i++){
            urls.add(url);
        }

    }

    private void initView() {

        mHead = findViewById(R.id.iv_personal_head);
        tv_personal_fans = findViewById(R.id.tv_personal_fans);
        tv_personal_profession = findViewById(R.id.tv_personal_profession);
        btn1 = findViewById(R.id.btn_personal1);
        btn2 = findViewById(R.id.btn_personal2);
        mRecyclerView = findViewById(R.id.recycler_personal);
    }
}
