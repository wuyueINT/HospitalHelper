package com.wuyue.bottom_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wuyue.find.BlankFragment_find;
import com.wuyue.hospitalhelper.BlankFragment_focus;
import com.wuyue.hospitalhelper.R;
import com.wuyue.question.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类用于多个Fragment
 *
 */

public class BlankFragment_bottom extends Fragment {

    private int type;
    private List<Fragment> fragments;
    private TabLayout tabLayout;
    private ViewPager vp;

    public BlankFragment_bottom(int i) {
        super();
        this.type = i;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        if (type==0){
            //关注和收藏页面,这个页面使用viewpager和fragment的组合实现
            view = inflater.inflate(R.layout.viewpager_focus, null);
            vp = view.findViewById(R.id.viewpager_focus);
            tabLayout = view.findViewById(R.id.tablayout);
            fragments = new ArrayList<>();
            String[] titles = {"关注", "收藏"};

            for (int i=0; i<titles.length; i++){
                fragments.add(BlankFragment_focus.newInstance(i));
                tabLayout.addTab(tabLayout.newTab());
            }

            vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }
            });

            tabLayout.setupWithViewPager(vp);

            for (int i=0; i<titles.length; i++){
                tabLayout.getTabAt(i).setText(titles[i]);
            }

        } else if (type==1){ //寻找页面

            view = inflater.inflate(R.layout.viewpager_find, null);
            String[] titles = {"找医生", "找医院", "找患者"};
            vp = view.findViewById(R.id.viewpager_find);
            tabLayout = view.findViewById(R.id.tablayout);
            fragments = new ArrayList<>();

            for (int i=0; i<titles.length; i++){
                fragments.add(BlankFragment_find.newInstance(i));
                tabLayout.addTab(tabLayout.newTab());
            }

            vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }
            });

            tabLayout.setupWithViewPager(vp);
            for (int i=0; i<titles.length; i++){
                tabLayout.getTabAt(i).setText(titles[i]);
            }

        } else if (type==2){

            view = inflater.inflate(R.layout.viewpager_question, null);
            fragments = new ArrayList<>();
            tabLayout = view.findViewById(R.id.tablayout);
            vp = view.findViewById(R.id.viewpager_question);
            String[] titles = {"回答","提问","查找"};

            for (int i=0; i<titles.length; i++){
                fragments.add(FragmentFactory.createProduct(titles[i]));
                tabLayout.addTab(tabLayout.newTab());
            }
            vp = view.findViewById(R.id.viewpager_question);
            vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }
            });
            tabLayout.setupWithViewPager(vp);
            for (int i=0; i<titles.length; i++){
                tabLayout.getTabAt(i).setText(titles[i]);
            }

        } else {
            //其他页面暂时没写
            view = inflater.inflate(R.layout.test, null);

        }

        return view;
    }
}
