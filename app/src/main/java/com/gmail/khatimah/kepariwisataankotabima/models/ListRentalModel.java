package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRentalModel {
    @SerializedName("data")
    private List<RentalModel> rData;

    public ListRentalModel(List<RentalModel> rData) {
        this.rData = rData;
    }


    public List<RentalModel> getrData() {
        return rData;
    }

    public void setrData(List<RentalModel> rData) {
        this.rData = rData;
    }
}
