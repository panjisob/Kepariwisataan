package com.gmail.khatimah.kepariwisataankotabima.services;

import com.gmail.khatimah.kepariwisataankotabima.models.ListFasilitasodel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListHotelModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListLocationModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListRentalModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListTransportModel;
import com.gmail.khatimah.kepariwisataankotabima.models.LocationModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("JsonMarker.php")
    Call<ListLocationModel> getAllLocation();
    @GET("JsonMHotel.php")
    Call<ListHotelModel> getAllHotel();
    @GET("JsonMTranport.php")
    Call<ListTransportModel> getAllTransport();
    @GET("JsonMFasilitas.php")
    Call<ListFasilitasodel> getAllFasilitas();
    @GET("JsonMRental.php")
    Call<ListRentalModel> getAllRental();
}