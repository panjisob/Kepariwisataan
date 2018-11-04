package com.gmail.khatimah.kepariwisataankotabima;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.gmail.khatimah.kepariwisataankotabima.models.ListLocationModel;
import com.gmail.khatimah.kepariwisataankotabima.models.LocationModel;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiClient;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiService;

public class ListMap extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<LocationModel> mListMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_map);

        getAllDataLocationLatLng();



    }

    private void getAllDataLocationLatLng(){
//        final ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setMessage("Menampilkan data marker ..");
//        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModel> call = apiService.getAllLocation();
        call.enqueue(new Callback<ListLocationModel>() {
            @Override
            public void onResponse(Call<ListLocationModel> call, Response<ListLocationModel> response) {
//                dialog.dismiss();
                mListMarker = response.body().getmData();
                generateMapList(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModel> call, Throwable t) {
//                dialog.dismiss();
                Toast.makeText(ListMap.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateMapList(List<LocationModel> empDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapter = new RecyclerViewAdapter(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListMap.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
