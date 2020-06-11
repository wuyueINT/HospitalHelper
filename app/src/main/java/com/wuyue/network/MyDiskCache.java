package com.wuyue.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.android.volley.toolbox.ImageLoader;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 实现图片的本地缓存
 *
 */

public class MyDiskCache implements ImageLoader.ImageCache {

    String filepath = Environment.getExternalStorageDirectory()+"/images/";

    @Override
    public Bitmap getBitmap(String url) {
        Bitmap bitmap = BitmapFactory.decodeFile(filepath+url);
        return bitmap;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "images");
        if (!appDir.exists()){
            appDir.mkdirs();
        }
        String filename = url;
        File file = new File(appDir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
