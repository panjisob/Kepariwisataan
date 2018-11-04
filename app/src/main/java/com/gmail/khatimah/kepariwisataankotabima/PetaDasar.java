package com.gmail.khatimah.kepariwisataankotabima;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;

import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.nextome.geojsonify.GeoJsonify;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PetaDasar extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMyLocationButtonClickListener ,
        GoogleMap.OnMyLocationClickListener{

    // Deklarasi variable
    private GoogleMap mMap;
    private static final int COLOR_BLACK_ARGB = 0xff000000;
    private static final int COLOR_WHITE_ARGB = 0xffffffff;
    private static final int COLOR_GREEN_ARGB = 0xff388E3C;
    private static final int COLOR_PURPLE_ARGB = 0xff81C784;
    private static final int COLOR_ORANGE_ARGB = 0xffF57F17;
    private static final int COLOR_BLUE_ARGB = 0xffF9A825;

    private static final int POLYGON_STROKE_WIDTH_PX = 8;
    private static final int PATTERN_DASH_LENGTH_PX = 20;
    private static final int PATTERN_GAP_LENGTH_PX = 20;
    private static final PatternItem DOT = new Dot();
    private static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
    private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta_dasar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //mSearchText = (EditText) findViewById(R.id.input_search);




    }

    public void kecamatan(View view){
        GeoJsonLayer layer = null;
        try {
            layer = new GeoJsonLayer(mMap, R.raw.kecamatan,
                    getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        layer.addLayerToMap();


        for (GeoJsonFeature feature : layer.getFeatures()) {
            String TAG = "PetaDasar";

            String state = feature.getProperty("KECAMATAN");

            Object cordinate = feature.getGeometry().getGeometryObject();

            Log.d(TAG, "onMapReady: data property : Geometry " + cordinate);

            Log.d(TAG, "onMapReady: data property : KECAMATAN " + state);

            GeoJsonPolygonStyle polygonStyle = layer.getDefaultPolygonStyle();
            if (state.equals("KEC. ASAKOTA")) {
                Log.d(TAG, "onMapReady: data property : tidak dapat");
                Log.d(TAG, "onMapReady: data property : KECAMATAN " + state);
                polygonStyle.setFillColor(Color.argb(128, 255, 0, 0));
                polygonStyle.setStrokeColor(COLOR_BLUE_ARGB);
            }
//            polygonStyle.setFillColor(COLOR_WHITE_ARGB);
//            polygonStyle.setStrokeColor(COLOR_BLUE_ARGB);



        }
    }
    public void jalan(View view){
        GeoJsonLayer layer2 = null;
        try {
            layer2 = new GeoJsonLayer(mMap, R.raw.jalan,
                    getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        layer2.addLayerToMap();

        for (GeoJsonFeature feature : layer2.getFeatures()) {
            String TAG = "PetaDasar";

            String state = feature.getProperty("KECAMATAN");



            GeoJsonPolygonStyle polygonStyle = layer2.getDefaultPolygonStyle();




        }
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
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mMap.setMyLocationEnabled(true);

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        LatLng bima = new LatLng(-8.4628462,118.727206);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bima, 10));

        //-8.4628462,118.727206
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
}
