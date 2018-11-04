package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListHotelModel {
    @SerializedName("data")
    private List<HotelModel> hData;

    public ListHotelModel(List<HotelModel> mData) {
        this.hData = hData;
    }


    public List<HotelModel> gethData() {
        return hData;
    }

    public void sethData(List<HotelModel> hData) {
        this.hData = hData;
    }
}
