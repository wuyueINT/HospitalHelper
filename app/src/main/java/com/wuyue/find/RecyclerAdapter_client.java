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

public class RecyclerAdapter_client extends RecyclerView.Adapter<RecyclerAdapter_client.VH> {

    private Context context;
    private List<ClientLog> logs;

    public RecyclerAdapter_client(Context context, List<ClientLog> logs) {
        this.context = context;
        this.logs = logs;
    }

    @NonNull
    @Override
    public RecyclerAdapter_client.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_client, parent, false);
        return new RecyclerAdapter_client.VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_client.VH holder, int position) {
        ClientLog client = logs.get(position);
        holder.iv_client_pic.setImageBitmap(client.getClient_pic());
        holder.tv_client_project.setText(client.getClient_project());
        holder.tv_client_location.setText(client.getClient_loc());
        holder.tv_client_require.setText(client.getClient_require());
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }


    public class VH extends RecyclerView.ViewHolder{

        private ImageView iv_client_pic;
        private TextView tv_client_project;
        private TextView tv_client_location;
        private TextView tv_client_require;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv_client_pic = itemView.findViewById(R.id.iv_client_pic);
            tv_client_project = itemView.findViewById(R.id.tv_client_project);
            tv_client_location = itemView.findViewById(R.id.tv_client_location);
            tv_client_require = itemView.findViewById(R.id.tv_client_require);
        }
    }
}
