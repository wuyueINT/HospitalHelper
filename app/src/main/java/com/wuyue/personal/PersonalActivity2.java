package com.wuyue.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuyue.hospitalhelper.R;

/**
 * 自己的个人主页
 *
 */

public class PersonalActivity2 extends AppCompatActivity {

    private ImageView mHead;
    private TextView fans;
    private TextView profession;
    private TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal2);
        initView();
        initData();
    }

    private void initData() {
        mHead.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.default_photo));
        fans.setText("收藏2  粉丝1");
        profession.setText("认证 山大骨科主任");
        String s = "毕业于/n山西医科大学 硕士 2001.7/n就职于/n山西医科大学第二医院 骨科";
        intro.setText(s);
    }

    private void initView() {
        mHead = findViewById(R.id.iv_personal_head);
        fans = findViewById(R.id.tv_personal_fans);
        profession = findViewById(R.id.tv_personal_profession);
        intro = findViewById(R.id.tv_personal_intro);
    }


}
