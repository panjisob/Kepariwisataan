package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListLocationModel {
    @SerializedName("data")
    private List<LocationModel> mData;

    public ListLocationModel(List<LocationModel> mData) {
        this.mData = mData;
    }


    public List<LocationModel> getmData() {
        return mData;
    }

    public void setmData(List<LocationModel> mData) {
        this.mData = mData;
    }
}
