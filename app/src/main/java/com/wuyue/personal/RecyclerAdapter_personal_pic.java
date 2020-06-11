package com.wuyue.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wuyue.hospitalhelper.R;
import com.wuyue.network.MyImageLoader;

import java.util.List;

public class RecyclerAdapter_personal_pic extends RecyclerView.Adapter<RecyclerAdapter_personal_pic.VH> {

    private Context context;
    private List<String> urls;
    private MyImageLoader myImageLoader;

    public RecyclerAdapter_personal_pic(Context context, List<String> urls) {
        this.context = context;
        this.urls = urls;
        myImageLoader = MyImageLoader.getInstance(context);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_personal_pic, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        String url = urls.get(position);
        myImageLoader.useImageLoader(url, holder.imageView);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    class VH extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.personal_pic);
        }
    }
}
