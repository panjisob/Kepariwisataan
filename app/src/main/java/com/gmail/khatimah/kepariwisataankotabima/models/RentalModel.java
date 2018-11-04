package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

public class RentalModel {
    @SerializedName("ren_car")
    private String renCar;
    @SerializedName("latitude")
    private String latutide;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("no_hp")
    private String noHp;

    public RentalModel(String renCar, String latutide, String longitude, String keterangan, String noHp) {
        this.renCar = renCar;
        this.latutide = latutide;
        this.longitude = longitude;
        this.keterangan = keterangan;
        this.noHp = noHp;
    }


    public String getRenCar() {
        return renCar;
    }

    public void setRenCar(String renCar) {
        this.renCar = renCar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.keterangan = noHp;
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
