package com.wuyue.hospitalhelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * “发现”页面的碎片，是RecyclerView的容器，负责存放医生的动态信息
 *
 */

public class BlankFragment_main extends Fragment {

    private XRecyclerView recyclerView;
    private RecyclerAdapter_main adapter;
    private int label = -1; //用于标识关注1，收藏2

    private BlankFragment_main(int a){
        label = a;
    }

    public static Fragment newInstance(int a){
        BlankFragment_main fragment = new BlankFragment_main(a);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement01_main, null);
        recyclerView = view.findViewById(R.id.recycler_main);
        
        //在这里为RecyclerView准备医生的动态数据
        List<DoctorLog> doctorLogs = new ArrayList<>();
        if (label==1){
            doctorLogs = createDataA();
        } else if (label==2){
            doctorLogs = createDataC();
        }

        adapter = new RecyclerAdapter_main(getActivity(), doctorLogs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        //下拉刷新
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_LONG).show();
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_LONG).show();
                recyclerView.loadMoreComplete();
            }
        });



        return view;
    }

    /**
     * 随机生成关注页面测试数据
     * @return
     */
    private List<DoctorLog> createDataA() {

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


    /**
     * 随机生成收藏页面测试数据
     * @return
     */
    private List<DoctorLog> createDataC() {

        List<DoctorLog> doctorLogs = new ArrayList<>();




        return doctorLogs;
    }

}
