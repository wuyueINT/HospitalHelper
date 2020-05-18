package com.wuyue.hospitalhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 这个页面同时也是“发现”页面
 *
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager_main;
    private List<Fragment> fragments;
    private TextView tv1;
    private TextView tv2;
    private Button tabline;
    int currentPage = 0;
    int tabLineLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabLine();
        initView();
    }


    private void initView() {

        viewPager_main = findViewById(R.id.viewpager_main);
        tv1 = findViewById(R.id.tv_attention);
        tv2 = findViewById(R.id.tv_collection);

        fragments = new ArrayList<>();
        fragments.add(BlankFragment_main.newInstance(1));
        fragments.add(BlankFragment_main.newInstance(2));

        //设置适配器
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

        //关注与收藏的滑动监听
        viewPager_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams) tabline.getLayoutParams();

                if (currentPage==0 && position==0){
                    ll.leftMargin = (int)(currentPage*tabLineLength+positionOffset*tabLineLength);
                } else if (currentPage==1 && position==0){
                    ll.leftMargin = (int)(currentPage*tabLineLength+positionOffset*tabLineLength-tabLineLength);
                }

                tabline.setLayoutParams(ll);
            }

            @Override
            public void onPageSelected(int position) {
                tv1.setTextColor(Color.BLACK);
                tv2.setTextColor(Color.BLACK);

                switch (position){
                    case 0:
                        tv1.setTextColor(Color.rgb(51, 153, 0));
                        break;
                    case 1:
                        tv2.setTextColor(Color.rgb(51, 153, 0));
                        break;
                }
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //初始化滑动条
    private void initTabLine() {
        // 获取显示屏信息
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        // 得到显示屏宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 1/3屏幕宽度
        tabLineLength = metrics.widthPixels / 2;
        // 获取控件实例
        tabline = (Button) findViewById(R.id.tabline_main);
        // 控件参数
        ViewGroup.LayoutParams lp = tabline.getLayoutParams();
        lp.width = tabLineLength;
        tabline.setLayoutParams(lp);
    }
}
