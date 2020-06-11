package com.wuyue.network;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;

public class DoubleCache implements ImageLoader.ImageCache {

    private MyDiskCache diskCache;
    private MyImageCache imageCache;

    public DoubleCache() {
        this.diskCache = new MyDiskCache();
        this.imageCache = new MyImageCache();
    }

    @Override
    public Bitmap getBitmap(String url) {
        Bitmap bitmap = imageCache.getBitmap(url);
        if (bitmap==null){
            bitmap = diskCache.getBitmap(url);
        }
        return bitmap;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        imageCache.put(url, bitmap);
        diskCache.putBitmap(url, bitmap);
    }
}
