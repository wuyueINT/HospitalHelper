package com.wuyue.hospitalhelper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wuyue.personal.PersonalActivity;

import java.util.List;


/**
 *
 * 存放医生动态信息的RecyclerView的具体容器，数据为测试生成数据
 *
 */

public class RecyclerAdapter_focus extends XRecyclerView.Adapter<RecyclerAdapter_focus.VH> {

    private List<DoctorLog> doctorLogs;
    private Context context;

    public RecyclerAdapter_focus(Context context, List<DoctorLog> doctorLogs) {
        this.doctorLogs = doctorLogs;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_main, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DoctorLog doctorLog = doctorLogs.get(position);
        holder.imageView.setImageBitmap(doctorLog.getBitmap());
        holder.tv1.setText(doctorLog.getDate());
        String s = doctorLog.getName() + " " + doctorLog.getPro();
        holder.tv2.setText(s);
        holder.tv3.setText(doctorLog.getLog());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, PersonalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
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
