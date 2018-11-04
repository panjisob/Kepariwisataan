package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

public class HotelModel {
    @SerializedName("nama_hotel")
    private String namaHotel;
    @SerializedName("latitude")
    private String latutide;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("keterangan")
    private String keterangan;

    public HotelModel(String namaHotel, String latutide, String longitude, String keterangan) {
        this.namaHotel = namaHotel;
        this.latutide = latutide;
        this.longitude = longitude;
        this.keterangan = keterangan;
    }


    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getKeteranganHotel() {
        return keterangan;
    }

    public void setKeteranganHotel(String keterangan) {
        this.keterangan = keterangan;
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
