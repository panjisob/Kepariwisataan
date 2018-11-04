package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

public class FasilitasModel {
    @SerializedName("fasilitas_umum")
    private String fasilitasUmum;
    @SerializedName("latitude")
    private String latutide;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("alamat")
    private String alamat;

    public FasilitasModel(String fasilitasUmum, String latutide, String longitude, String alamat) {
        this.fasilitasUmum = fasilitasUmum;
        this.latutide = latutide;
        this.longitude = longitude;
        this.alamat = alamat;
    }


    public String getFasilitasUmum() {
        return fasilitasUmum;
    }

    public void setFasilitasUmum(String fasilitasUmum) {
        this.fasilitasUmum = fasilitasUmum;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLatutide() {
        return latutide;
    }

    public void setLatutide(String latutide) {
        this.latutide = latutide;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
