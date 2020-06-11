package com.wuyue.question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.hospitalhelper.R;


import java.util.List;

public class RecyclerAdapter_ans extends XRecyclerView.Adapter<RecyclerAdapter_ans.VH> {

    private Context context;
    private List<AnsLog> ansLogs;

    public RecyclerAdapter_ans(Context context, List<AnsLog> ansLogs) {
        this.context = context;
        this.ansLogs = ansLogs;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_ans, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        AnsLog ansLog = ansLogs.get(position);
        String reward = "悬赏：￥" + ansLog.getReward();
        holder.tv_reward.setText(reward);
        String timelimit = "悬赏截止于：" + ansLog.getTimelimit() + "h后";
        holder.tv_timelimit.setText(timelimit);
        holder.tv_ques.setText(ansLog.getQuestion());
        holder.btn_ans.setText(ansLog.getAnswer());
        String follow = ansLog.getFollow() + " 关注+";
        holder.btn_follow.setText(follow);

        //根据labels里的标签数，向布局中添加标签
        String[] labels = ansLog.getLabels();
        holder.ll_label.removeAllViews();
        for (int i=0; i<labels.length; i++){
            if (i>=3) break;

            View view = LayoutInflater.from(context).inflate(R.layout.label, null);
            com.foxmail.aroundme.library.LabelTextView tv_label = view.findViewById(R.id.tv_label);

            tv_label.setLabelText(labels[i]);
            holder.ll_label.addView(tv_label);
        }

        //添加关注事件
        holder.btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将该问题添加到关注名单
                Toast.makeText(context, "该功能还没做", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ansLogs.size();
    }

    public class VH extends XRecyclerView.ViewHolder{

        private TextView tv_reward;
        private TextView tv_timelimit;
        private TextView tv_ques;
        private Button btn_ans;
        private Button btn_follow;
        private LinearLayout ll_label;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv_reward = itemView.findViewById(R.id.tv_reward);
            tv_timelimit = itemView.findViewById(R.id.tv_timelimit);
            tv_ques = itemView.findViewById(R.id.tv_ques);
            btn_ans = itemView.findViewById(R.id.btn_ans);
            btn_follow = itemView.findViewById(R.id.btn_follow);
            ll_label = itemView.findViewById(R.id.ll_label);
        }
    }
}
