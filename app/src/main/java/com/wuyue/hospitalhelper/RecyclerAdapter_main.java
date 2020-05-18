package com.wuyue.hospitalhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 *
 * 存放医生动态信息的RecyclerView的具体容器，数据由
 *
 */

public class RecyclerAdapter_main extends RecyclerView.Adapter<RecyclerAdapter_main.VH> {

    private List<DoctorLog> doctorLogs;
    private Context context;

    public RecyclerAdapter_main(Context context, List<DoctorLog> doctorLogs) {
        this.doctorLogs = doctorLogs;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_main, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DoctorLog doctorLog = doctorLogs.get(position);
        holder.imageView.setImageBitmap(doctorLog.getBitmap());
        holder.tv1.setText(doctorLog.getDate());
        String s = doctorLog.getName() + doctorLog.getPro();
        holder.tv2.setText(s);
        holder.tv3.setText(doctorLog.getLog());
    }

    @Override
    public int getItemCount() {
        return doctorLogs.size();
    }


    public class VH extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_doctor);
            tv1 = itemView.findViewById(R.id.time_update);
            tv2 = itemView.findViewById(R.id.message_update);
            tv3 = itemView.findViewById(R.id.condition_update);
        }
    }

}
