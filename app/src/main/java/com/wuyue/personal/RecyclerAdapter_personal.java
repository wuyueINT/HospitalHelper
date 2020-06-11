package com.wuyue.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wuyue.hospitalhelper.DoctorLog;
import com.wuyue.hospitalhelper.R;

import java.util.List;

public class RecyclerAdapter_personal extends RecyclerView.Adapter<RecyclerAdapter_personal.VH> {

    private Context context;
    private List<DoctorLog> list;
    private RecyclerView.Adapter adapter;

    public RecyclerAdapter_personal(Context context, List<DoctorLog> list, List<String> urls) {
        this.context = context;
        this.list = list;
        adapter = new RecyclerAdapter_personal_pic(context, urls);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_personal, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DoctorLog doctorLog = list.get(position);
        holder.mHead.setImageBitmap(doctorLog.getBitmap());
        holder.date.setText(doctorLog.getDate());
        String msg = doctorLog.getName() + " " + doctorLog.getPro();
        holder.msg.setText(msg);
        holder.condition.setText(doctorLog.getLog());
        holder.recyclerView_pic.setLayoutManager(new GridLayoutManager(this.context, 3));
        holder.recyclerView_pic.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //布局资源
    public class VH extends RecyclerView.ViewHolder{

        private ImageView mHead;
        private TextView date;
        private TextView msg;
        private TextView condition;
        private RecyclerView recyclerView_pic;
        private Button btn1;
        private Button btn2;
        private Button btn3;

        public VH(@NonNull View itemView) {
            super(itemView);
            mHead = itemView.findViewById(R.id.image_doctor1);
            date = itemView.findViewById(R.id.time_update1);
            msg = itemView.findViewById(R.id.message_update1);
            condition = itemView.findViewById(R.id.condition_update1);
            recyclerView_pic = itemView.findViewById(R.id.recycler_pictures);
            btn1 = itemView.findViewById(R.id.btn_zhuanfa);
            btn2 = itemView.findViewById(R.id.btn_pinglun);
            btn3 = itemView.findViewById(R.id.btn_dianzan);

        }
    }
}
