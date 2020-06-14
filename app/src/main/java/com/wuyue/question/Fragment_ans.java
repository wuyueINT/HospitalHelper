package com.wuyue.question;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.hospitalhelper.R;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fragment_ans extends Product {

    private TextView query_for_reward;
    private TextView query_for_follow;
    private XRecyclerView recyclerView;
    private RecyclerAdapter_ans adapter_ans;

    List<AnsLog> ansLogs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ans, null);
        query_for_reward = view.findViewById(R.id.query_for_reward);
        query_for_follow = view.findViewById(R.id.query_for_follow);
        recyclerView = view.findViewById(R.id.recycler_ans);

        ansLogs = createData();
        adapter_ans = new RecyclerAdapter_ans(getActivity(), ansLogs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter_ans);

        //下拉刷新与上滑加载
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "上滑加载", Toast.LENGTH_SHORT).show();
            }
        });

        //按照赏金的多少对问题进行排序
        query_for_reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ansLogs.sort(new Comparator<AnsLog>() {
                    @Override
                    public int compare(AnsLog o1, AnsLog o2) {
                        return o2.getReward().compareTo(o1.getReward());
                    }
                });
                adapter_ans.notifyDataSetChanged();
            }
        });

        //按照关注量的多少对问题进行排序
        query_for_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ansLogs.sort(new Comparator<AnsLog>() {
                    @Override
                    public int compare(AnsLog o1, AnsLog o2) {
                        return o2.getFollow().compareTo(o1.getFollow());
                    }
                });
                adapter_ans.notifyDataSetChanged();
            }
        });

        return view;
    }

    //制造测试数据
    @Override
    public List<AnsLog> createData() {

        List<AnsLog> list = new ArrayList<>();

        AnsLog ansLog1 = new AnsLog();
        ansLog1.setReward((int)(Math.random()*10)+"");
        ansLog1.setTimelimit((int)(Math.random()*50)+"");
        ansLog1.setQuestion("求分享山医预院考研资料");
        String[] s1 = {"预防","限医生作答"};
        ansLog1.setLabels(s1);
        ansLog1.setAnswer((int)(Math.random()*10)+"");
        ansLog1.setFollow((int)(Math.random()*5)+"");
        list.add(ansLog1);

        for (int i=0; i<10; i++){

            AnsLog ansLog = new AnsLog();

            ansLog.setReward((int)(Math.random()*10)+"");
            ansLog.setTimelimit((int)(Math.random()*50)+"");
            ansLog.setQuestion("太原哪些医院正畸做的好？");
            String[] s = {"口腔科","正畸","考研"};
            ansLog.setLabels(s);
            ansLog.setAnswer((int)(Math.random()*10)+"");
            ansLog.setFollow((int)(Math.random()*5)+"");
            list.add(ansLog);
        }

        return list;
    }
}
