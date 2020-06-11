package com.wuyue.network;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.wuyue.hospitalhelper.R;

public class MyImageLoader{

    private RequestQueue mQueue;
    private DoubleCache mCache;
    private static MyImageLoader mImageLoader = null;

    private MyImageLoader(Context context) {

        this.mCache = new DoubleCache();
        this.mQueue = Volley.newRequestQueue(context);
    }

    public static MyImageLoader getInstance(Context context){
        if (mImageLoader==null){
            synchronized (MyImageLoader.class){
                if (mImageLoader==null){
                    return new MyImageLoader(context);
                }
            }
        }
        return mImageLoader;
    }


    public void useImageLoader(String url, ImageView mImageView){

        ImageLoader imageLoader = new ImageLoader(mQueue, mCache);
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(mImageView, R.drawable.load, R.drawable.fail);
        imageLoader.get(url, listener);

    }

}
