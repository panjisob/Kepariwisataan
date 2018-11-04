package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

public class TransportModel {
    @SerializedName("layanan_transportasi")
    private String laynanTransport;
    @SerializedName("latitude")
    private String latutide;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("keterangan")
    private String keterangan;

    public TransportModel(String laynanTransport, String latutide, String longitude, String keterangan) {
        this.laynanTransport = laynanTransport;
        this.latutide = latutide;
        this.longitude = longitude;
        this.keterangan = keterangan;
    }


    public String getLaynanTransport() {
        return laynanTransport;
    }

    public void setLaynanTransport(String laynanTransport) {
        this.laynanTransport = laynanTransport;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
