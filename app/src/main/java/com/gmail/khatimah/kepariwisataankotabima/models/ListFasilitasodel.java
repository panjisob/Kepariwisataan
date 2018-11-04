package com.gmail.khatimah.kepariwisataankotabima.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListFasilitasodel {
    @SerializedName("data")
    private List<FasilitasModel> fData;

    public ListFasilitasodel(List<FasilitasModel> fData) {
        this.fData = fData;
    }


    public List<FasilitasModel> getfData() {
        return fData;
    }

    public void setfData(List<FasilitasModel> fData) {
        this.fData = fData;
    }
}
