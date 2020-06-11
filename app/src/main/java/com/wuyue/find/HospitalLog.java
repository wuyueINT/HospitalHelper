package com.wuyue.find;

import android.graphics.Bitmap;

public class HospitalLog {

    Bitmap hospital_pic;
    String hospital_name;
    String hospital_loc;
    String Hospital_label;

    public HospitalLog() {
    }

    public HospitalLog(Bitmap hospital_pic, String hospital_name, String hospital_loc, String hospital_label) {
        this.hospital_pic = hospital_pic;
        this.hospital_name = hospital_name;
        this.hospital_loc = hospital_loc;
        Hospital_label = hospital_label;
    }

    public Bitmap getHospital_pic() {
        return hospital_pic;
    }

    public void setHospital_pic(Bitmap hospital_pic) {
        this.hospital_pic = hospital_pic;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_loc() {
        return hospital_loc;
    }

    public void setHospital_loc(String hospital_loc) {
        this.hospital_loc = hospital_loc;
    }

    public String getHospital_label() {
        return Hospital_label;
    }

    public void setHospital_label(String hospital_label) {
        Hospital_label = hospital_label;
    }

    @Override
    public String toString() {
        return "HospitalLog{" +
                "hospital_pic=" + hospital_pic +
                ", hospital_name='" + hospital_name + '\'' +
                ", hospital_loc='" + hospital_loc + '\'' +
                ", Hospital_label='" + Hospital_label + '\'' +
                '}';
    }
}
