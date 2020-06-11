package com.wuyue.find;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.hospitalhelper.DoctorLog;
import com.wuyue.hospitalhelper.R;
import com.wuyue.hospitalhelper.RecyclerAdapter_focus;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment_find extends Fragment {

    private int label = -1; //标识1代表找医生，2代表找医院， 3代表找患者
    private XRecyclerView recyclerView;
    private RecyclerAdapter_focus adapter_doctor;
    private RecyclerAdapter_hospital adapter_hospital;
    private RecyclerAdapter_client adapter_client;

    private BlankFragment_find(int label){
        this.label = label;
    }

    public static BlankFragment_find newInstance(int label){
        return new BlankFragment_find(label);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement01, null);
        recyclerView = view.findViewById(R.id.recycler_focus);

        //在这里为RecyclerView准备医生的动态数据
        if (label==0){ //找医生
            List<DoctorLog> logs = createDataA();
            adapter_doctor = new RecyclerAdapter_focus(getActivity(), logs);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter_doctor);

            //下拉刷新
            recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    //Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_LONG).show();
                    recyclerView.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    //Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_LONG).show();
                    recyclerView.loadMoreComplete();
                }
            });
        } else if (label==1){ //找医院
            List<HospitalLog> logs = createDataH();
            adapter_hospital = new RecyclerAdapter_hospital(getActivity(), logs);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter_hospital);
            //下拉刷新
            recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    //Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_LONG).show();
                    recyclerView.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    //Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_LONG).show();
                    recyclerView.loadMoreComplete();
                }
            });
        } else if (label==2){ //找患者

            List<ClientLog> logs = createDataC();
            adapter_client = new RecyclerAdapter_client(getActivity(), logs);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter_client);
            //下拉刷新
            recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    //Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_LONG).show();
                    recyclerView.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    //Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_LONG).show();
                    recyclerView.loadMoreComplete();
                }
            });
        }

        return view;
    }

    /**
     * 随机生成找医院页面测试数据
     *
     * @return
     */
    private List<HospitalLog> createDataH() {

        List<HospitalLog> list = new ArrayList<>();
        Bitmap default_photo = BitmapFactory.decodeResource(getResources(), R.drawable.default_photo);

        HospitalLog hospitalLog1 = new HospitalLog();
        hospitalLog1.setHospital_pic(default_photo);
        hospitalLog1.setHospital_name("阳明医院");
        hospitalLog1.setHospital_loc("太原市迎泽区");
        hospitalLog1.setHospital_label("公立三甲");
        list.add(hospitalLog1);

        HospitalLog hospitalLog2 = new HospitalLog();
        hospitalLog2.setHospital_pic(default_photo);
        hospitalLog2.setHospital_name("阳明诊所");
        hospitalLog2.setHospital_loc("太原市迎泽区");
        hospitalLog2.setHospital_label("价格亲民");
        list.add(hospitalLog2);

        HospitalLog hospitalLog3 = new HospitalLog();
        hospitalLog3.setHospital_pic(default_photo);
        hospitalLog3.setHospital_name("阳明医院");
        hospitalLog3.setHospital_loc("太原市迎泽区");
        hospitalLog3.setHospital_label("距离较近");
        list.add(hospitalLog3);

        HospitalLog hospitalLog4 = new HospitalLog();
        hospitalLog4.setHospital_pic(default_photo);
        hospitalLog4.setHospital_name("阳明医院");
        hospitalLog4.setHospital_loc("太原市迎泽区");
        hospitalLog4.setHospital_label("公立三甲");
        list.add(hospitalLog4);

        return list;
    }

    /**
     * 随机生成找医生页面测试数据
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
        doctorLog3.setPro("山大二院骨科主任");
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
     * 随机生成找客户页面测试数据
     * @return
     */
    private List<ClientLog> createDataC() {

        List<ClientLog> list = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.default_photo);

        ClientLog clientLog1 = new ClientLog();
        clientLog1.setClient_pic(bitmap);
        clientLog1.setClient_loc("fafdaf");
        clientLog1.setClient_project("kjlkol");
        clientLog1.setClient_require("jhfaouhao");
        list.add(clientLog1);

        ClientLog clientLog2 = new ClientLog();
        clientLog2.setClient_pic(bitmap);
        clientLog2.setClient_loc("fafdaf");
        clientLog2.setClient_project("kjlkol");
        clientLog2.setClient_require("jhfaouhao");
        list.add(clientLog2);

        ClientLog clientLog3 = new ClientLog();
        clientLog3.setClient_pic(bitmap);
        clientLog3.setClient_loc("fafdaf");
        clientLog3.setClient_project("kjlkol");
        clientLog3.setClient_require("jhfaouhao");
        list.add(clientLog3);

        ClientLog clientLog4 = new ClientLog();
        clientLog4.setClient_pic(bitmap);
        clientLog4.setClient_loc("fafdaf");
        clientLog4.setClient_project("kjlkol");
        clientLog4.setClient_require("jhfaouhao");
        list.add(clientLog4);


        return list;
    }


}
