package com.wuyue.hospitalhelper;

import android.graphics.Bitmap;

/**
 *
 * 用于储存医生的个人信息与动态日志
 *
 */

public class DoctorLog {

    Bitmap bitmap;
    String date;
    String name;
    String pro;
    String log;

    public DoctorLog(Bitmap bitmap, String date, String name, String pro, String log) {
        this.bitmap = bitmap;
        this.date = date;
        this.name = name;
        this.pro = pro;
        this.log = log;
    }

    public DoctorLog() {
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "DoctorLog{" +
                "bitmap=" + bitmap +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", pro='" + pro + '\'' +
                ", log='" + log + '\'' +
                '}';
    }
}
