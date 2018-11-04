package com.gmail.khatimah.kepariwisataankotabima;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.khatimah.kepariwisataankotabima.models.HotelModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListHotelModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListLocationModel;
import com.gmail.khatimah.kepariwisataankotabima.models.ListTransportModel;
import com.gmail.khatimah.kepariwisataankotabima.models.LocationModel;
import com.gmail.khatimah.kepariwisataankotabima.models.TransportModel;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiClient;
import com.gmail.khatimah.kepariwisataankotabima.services.ApiService;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.kml.KmlLayer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapsActivity extends FragmentActivity implements OnMyLocationButtonClickListener,
        OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText mSearchText;
    private ImageView mGps;
    private KmlLayer layer;
    private static final String TAG = "MapsActivity";
    private List<LocationModel> mListMarker = new ArrayList<>();
    private List<HotelModel> hListMarker = new ArrayList<>();
    private List<TransportModel> tListMarker = new ArrayList<>();

    LatLng myPosition;
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

        // Enabling MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

        // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            // Getting latitude of the current location
            double latitude = location.getLatitude();

            // Getting longitude of the current location
            double longitude = location.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude, longitude);

            myPosition = new LatLng(latitude, longitude);

            mMap.addMarker(new MarkerOptions().position(myPosition).title("Start"));
        }


        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);


        PolygonOptions rectOptions = new PolygonOptions()
                .add(new LatLng(-8.4836308,118.6667631),
                        new LatLng(-8.4476351,118.6873625),
                        new LatLng(-8.4177493,118.6859892),
                        new LatLng(-8.3769923,118.6873625),
                        new LatLng(-8.3668023,118.6262511),
                        new LatLng(-8.3953335,118.55278),
                        new LatLng(-8.4768394,118.5617064),
                        new LatLng(-8.4863473,118.5891722),
                        new LatLng(-8.4924594,118.6447905),
                        new LatLng(-8.4836308,118.6667631)).fillColor(Color.BLUE).fillColor(Color.RED);

// Get back the mutable Polygon
        Polygon polygon1 = mMap.addPolygon(rectOptions);

        polygon1.setTag("alpha");

        getAllDataLocationLatLng();
        getAllDataHotelLatLng();
        getAllDataTransportLatLng();
    }



    public void listmap(View view){
        Intent intent = new Intent(MapsActivity.this, ListMap.class);
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
                Toast.makeText(MapsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MapsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MapsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(MapsActivity.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapsActivity.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    startActivity(intent);
                }
            });
            //set latlng index ke 0
//            LatLng latLng = new LatLng(Double.parseDouble(mListMarker.get(0).getLatutide()), Double.parseDouble(mListMarker.get(0).getLongitude()));
//            //lalu arahkan zooming ke marker index ke 0
//            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude,latLng.longitude), 14.0f));
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
                    Toast.makeText(MapsActivity.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapsActivity.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    intent.putExtra("DESC", marker.getSnippet());
                    startActivity(intent);
                }
            });

        }
    }
    /**
     * Method ini digunakan untuk menampilkan semua marker di maps dari data yang didapat dari database
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
                    Toast.makeText(MapsActivity.this, "Info window clicked " + marker.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapsActivity.this, About.class);
                    intent.putExtra("TITLE", marker.getTitle());
                    intent.putExtra("DESC", marker.getSnippet());
                    startActivity(intent);
                }
            });

        }
    }
}
