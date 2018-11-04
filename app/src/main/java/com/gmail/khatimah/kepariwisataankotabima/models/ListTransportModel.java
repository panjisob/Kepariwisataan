package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListTransportModel {
    @SerializedName("data")
    private List<TransportModel> tData;

    public ListTransportModel(List<TransportModel> tData) {
        this.tData = tData;
    }


    public List<TransportModel> gettData() {
        return tData;
    }

    public void settData(List<TransportModel> tData) {
        this.tData = tData;
    }
}
