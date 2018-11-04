package com.gmail.khatimah.kepariwisataankotabima;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.khatimah.kepariwisataankotabima.models.FasilitasModel;
import com.gmail.khatimah.kepariwisataankotabima.models.HotelModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListFasilitasodel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListHotelModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListTransportModel;
import com.gmail.khatimah.kepariwisataankotabima.models.TransportModel;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;

import com.gmail.khatimah.kepariwisataankotabima.models.ListLocationModel;
import com.gmail.khatimah.kepariwisataankotabima.models.LocationModel;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiClient;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiService;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.PolyUtil;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetaSintetic extends FragmentActivity implements OnMapReadyCallback ,GoogleMap.OnMyLocationButtonClickListener ,
        GoogleMap.OnMyLocationClickListener {

    private GoogleMap mMap;
    private EditText mSearchText;
    private ImageView mGps;
    private KmlLayer layer;
    private static final String TAG = "PetaSintetic";
    private List<LocationModel> mListMarker = new ArrayList<>();
    private List<HotelModel> hListMarker = new ArrayList<>();
    private List<TransportModel> tListMarker = new ArrayList<>();
    private List<FasilitasModel> fListMarker = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta_sintetic);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //mSearchText = (EditText) findViewById(R.id.input_search);



    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mMap.setMyLocationEnabled(true);

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        LatLng bima = new LatLng(-8.4628462,118.727206);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bima, 10));

    }

    public void wifi(View view){
        mMap.clear();
        getAllDataLocationLatLng();
    }
    public void hotel(View view) {
        mMap.clear();
        getAllDataHotelLatLng();
    }
    public void tranport(View view) {
        mMap.clear();
        getAllDataTransportLatLng();
    }
    public void fasilitas(View view) {
        getAllDataFasilitasLatLng();
        mMap.clear();
    }

    public void listmap(View view){
        Intent intent = new Intent(PetaSintetic.this, ListMap.class);
        startActivity(intent);
    }
    @Override
    public void onMyLocationClick(Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
        mMap.clear();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()), 14.0f));
        MarkerOptions mp = new MarkerOptions();

        mp.position(new LatLng(location.getLatitude(), location.getLongitude()));

        mp.title("my position");

        mMap.addMarker(mp);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    /**
     * method ini digunakan menampilkan data marker dari database
     */
    private void getAllDataLocationLatLng(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModel> call = apiService.getAllLocation();
        call.enqueue(new Callback<ListLocationModel>() {
            @Override
            public void onResponse(Call<ListLocationModel> call, Response<ListLocationModel> response) {
                dialog.dismiss();
                mListMarker = response.body().getmData();
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(PetaSintetic.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * method ini digunakan menampilkan data hotel dari database
     */
    private void getAllDataHotelLatLng(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListHotelModel> call = apiService.getAllHotel();
        call.enqueue(new Callback<ListHotelModel>() {
            @Override
            public void onResponse(Call<ListHotelModel> call, Response<ListHotelModel> response) {
                dialog.dismiss();
                hListMarker = response.body().gethData();
                Log.d(TAG, "onResponse: datanya : "+ hListMarker.get(1).getNamaHotel());
                initMarkerH(hListMarker);
            }

            @Override
            public void onFailure(Call<ListHotelModel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(PetaSintetic.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * method ini digunakan menampilkan data fasilitas dari database
     */
    private void getAllDataFasilitasLatLng(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListFasilitasodel> call = apiService.getAllFasilitas();
        call.enqueue(new Callback<ListFasilitasodel>() {
            @Override
            public void onResponse(Call<ListFasilitasodel> call, Response<ListFasilitasodel> response) {
                dialog.dismiss();
                fListMarker = response.body().getfData();
                Log.d(TAG, "onResponse: datanya : "+ fListMarker.get(1).getFasilitasUmum());
                initMarkerF(fListMarker);
            }

            @Override
            public void onFailure(Call<ListFasilitasodel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(PetaSintetic.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * method ini digunakan menampilkan data hotel dari database
     */
    private void getAllDataTransportLatLng(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListTransportModel> call = apiService.getAllTransport();
        call.enqueue(new Callback<ListTransportModel>() {
            @Override
            public void onResponse(Call<ListTransportModel> call, Response<ListTransportModel> response) {
                dialog.dismiss();
                tListMarker = response.body().gettData();
                Log.d(TAG, "onResponse: datanya tranposrt : "+ tListMarker.get(1).getLaynanTransport());
                initMarkerT(tListMarker);
            }

            @Override
            public void onFailure(Call<ListTransportModel> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(PetaSintetic.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Method ini digunakan untuk menampilkan semua marker di maps dari data yang didapat dari database
     * @param listData
     */
    private void initMarker(List<LocationModel> listData){
        //iterasi semua data dan tampilkan markernya
        int i ;
        for ( i=0; i<mListMarker.size(); i++){
            //set latlng nya
            LatLng location = new LatLng(Double.parseDouble(mListMarker.get(i).getLatutide()), Double.parseDouble(mListMarker.get(i).getLongitude()));
            //tambahkan markernya
            mMap.addMarker(new MarkerOptions().position(location).title(mListMarker.get(i).getImageLocationName()));
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(PetaSintetic.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PetaSintetic.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    startActivity(intent);
                }
            });
            //set latlng index ke 0
            LatLng latLng = new LatLng(Double.parseDouble(mListMarker.get(0).getLatutide()), Double.parseDouble(mListMarker.get(0).getLongitude()));
            //lalu arahkan zooming ke marker index ke 0
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 14.0f));
        }
    }


    /**
     * Method ini digunakan untuk menampilkan semua marker di maps dari data yang didapat dari database
     * @param listData
     */
    private void initMarkerH(List<HotelModel> listData){
        //iterasi semua data dan tampilkan markernya
        int i ;
        for ( i=0; i<hListMarker.size(); i++){
            //set latlng nya
            LatLng location = new LatLng(Double.parseDouble(hListMarker.get(i).getLatutide()), Double.parseDouble(hListMarker.get(i).getLongitude()));
            //tambahkan markernya
            mMap.addMarker(new MarkerOptions().position(location)
                    .title(hListMarker.get(i).getNamaHotel())
                    .snippet(hListMarker.get(i).getKeteranganHotel())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hotel)));

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(PetaSintetic.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PetaSintetic.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    intent.putExtra("DESC", marker.getSnippet());
                    startActivity(intent);
                }
            });
            //set latlng index ke 0
            LatLng latLng = new LatLng(Double.parseDouble(hListMarker.get(0).getLatutide()), Double.parseDouble(hListMarker.get(0).getLongitude()));
            //lalu arahkan zooming ke marker index ke 0
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 14.0f));
        }
    }
    /**
     * Method ini digunakan untuk menampilkan semua marker transport di maps dari data yang didapat dari database
     * @param listData
     */
    private void initMarkerT(List<TransportModel> listData){
        //iterasi semua data dan tampilkan markernya
        int i ;
        for ( i=0; i<tListMarker.size(); i++){
            //set latlng nya
            LatLng location = new LatLng(Double.parseDouble(tListMarker.get(i).getLatutide()), Double.parseDouble(tListMarker.get(i).getLongitude()));
            //tambahkan markernya
            mMap.addMarker(new MarkerOptions().position(location)
                    .title(tListMarker.get(i).getLaynanTransport())
                    .snippet(tListMarker.get(i).getKeterangan())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_transport)));

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(PetaSintetic.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PetaSintetic.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    intent.putExtra("DESC", marker.getSnippet());
                    startActivity(intent);
                }
            });
            //set latlng index ke 0
            LatLng latLng = new LatLng(Double.parseDouble(tListMarker.get(0).getLatutide()), Double.parseDouble(tListMarker.get(0).getLongitude()));
            //lalu arahkan zooming ke marker index ke 0
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 14.0f));
        }
    }
    /**
     * Method ini digunakan untuk menampilkan semua marker fasilitas di maps dari data yang didapat dari database
     * @param listData
     */
    private void initMarkerF(List<FasilitasModel> listData){
        //iterasi semua data dan tampilkan markernya
        int i ;
        for ( i=0; i<fListMarker.size(); i++){
            //set latlng nya
            LatLng location = new LatLng(Double.parseDouble(fListMarker.get(i).getLatutide()), Double.parseDouble(fListMarker.get(i).getLongitude()));
            //tambahkan markernya
            mMap.addMarker(new MarkerOptions().position(location)
                    .title(fListMarker.get(i).getFasilitasUmum())
                    .snippet(fListMarker.get(i).getAlamat())
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fasilitas)));

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(PetaSintetic.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PetaSintetic.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    intent.putExtra("DESC", marker.getSnippet());
                    startActivity(intent);
                }
            });
            //set latlng index ke 0
            LatLng latLng = new LatLng(Double.parseDouble(fListMarker.get(0).getLatutide()), Double.parseDouble(fListMarker.get(0).getLongitude()));
            //lalu arahkan zooming ke marker index ke 0
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 14.0f));
        }
    }

}

