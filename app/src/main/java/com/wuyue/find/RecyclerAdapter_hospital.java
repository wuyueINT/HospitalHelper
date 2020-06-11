package com.wuyue.find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wuyue.hospitalhelper.R;

import java.util.List;

public class RecyclerAdapter_hospital extends RecyclerView.Adapter<RecyclerAdapter_hospital.VH> {

    private Context context;
    private List<HospitalLog> hospitalLogs;

    public RecyclerAdapter_hospital(Context context, List<HospitalLog> hospitalLogs) {
        this.context = context;
        this.hospitalLogs = hospitalLogs;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_hospital, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        HospitalLog hospitalLog = hospitalLogs.get(position);
        holder.iv_hospital_pic.setImageBitmap(hospitalLog.getHospital_pic());
        holder.tv_hospital_name.setText(hospitalLog.getHospital_name());
        holder.tv_hospital_loc.setText(hospitalLog.getHospital_loc());
        holder.tv_hospital_label.setText(hospitalLog.getHospital_label());
    }

    @Override
    public int getItemCount() {
        return hospitalLogs.size();
    }


    public class VH extends RecyclerView.ViewHolder{

        private ImageView iv_hospital_pic;
        private TextView tv_hospital_label;
        private TextView tv_hospital_name;
        private TextView tv_hospital_loc;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv_hospital_pic = itemView.findViewById(R.id.iv_hospital_pic);
            tv_hospital_label = itemView.findViewById(R.id.tv_hospital_label);
            tv_hospital_name = itemView.findViewById(R.id.tv_hospital_name);
            tv_hospital_loc = itemView.findViewById(R.id.tv_hospital_loc);
        }
    }
}
