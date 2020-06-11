package com.wuyue.hospitalhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.tabs.TabLayout;
import com.wuyue.bottom_menu.BlankFragment_bottom;
import com.wuyue.personal.PersonalActivity2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * “发现”页面
 *
 */

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 1;
    private List<Fragment> fragments;
    private Button btn_personal;
    private Button btn_add;
    private RadioGroup rd_group;
    private ViewPager viewPager_main;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);

        initPermission();
        initView();
    }

    private void initView() {

        viewPager_main = findViewById(R.id.viewpager_main);
        rd_group = findViewById(R.id.rd_group);
        btn_personal = findViewById(R.id.btn_personal);
        btn_add = findViewById(R.id.btn_add);

        //点击进入个人主页
        btn_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PersonalActivity2.class));
            }
        });

        //点击下方菜单栏进入不同的页面fragment
        fragments = new ArrayList<>();
        for (int i=0; i<4; i++){
            fragments.add(new BlankFragment_bottom(i));
        }

        viewPager_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        //为RadioGroup绑定点击事件
        rd_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd_focus:
                        viewPager_main.setCurrentItem(0, false);
                        break;
                    case R.id.rd_find:
                        viewPager_main.setCurrentItem(1, false);
                        break;
                    case R.id.rd_question:
                        viewPager_main.setCurrentItem(2, false);
                        break;
                    case R.id.rd_campus:
                        viewPager_main.setCurrentItem(3, false);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    //动态请求权限
    private void initPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.e("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }
}

