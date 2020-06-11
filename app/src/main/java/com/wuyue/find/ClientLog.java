package com.wuyue.find;

import android.graphics.Bitmap;

public class ClientLog {

    String client_project;
    String client_loc;
    String client_require;
    Bitmap client_pic;

    public ClientLog() {
    }

    public ClientLog(String client_project, String client_loc, String client_require, Bitmap client_pic) {
        this.client_project = client_project;
        this.client_loc = client_loc;
        this.client_require = client_require;
        this.client_pic = client_pic;
    }

    public String getClient_project() {
        return client_project;
    }

    public void setClient_project(String client_project) {
        this.client_project = client_project;
    }

    public String getClient_loc() {
        return client_loc;
    }

    public void setClient_loc(String client_loc) {
        this.client_loc = client_loc;
    }

    public String getClient_require() {
        return client_require;
    }

    public void setClient_require(String client_require) {
        this.client_require = client_require;
    }

    public Bitmap getClient_pic() {
        return client_pic;
    }

    public void setClient_pic(Bitmap client_pic) {
        this.client_pic = client_pic;
    }

    @Override
    public String toString() {
        return "ClientLog{" +
                "client_project='" + client_project + '\'' +
                ", client_loc='" + client_loc + '\'' +
                ", client_require='" + client_require + '\'' +
                ", client_pic=" + client_pic +
                '}';
    }
}
