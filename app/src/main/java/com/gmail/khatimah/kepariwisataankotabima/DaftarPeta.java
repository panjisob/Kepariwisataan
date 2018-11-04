package com.gmail.khatimah.kepariwisataankotabima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DaftarPeta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_peta);
    }

    public void peta_dasar(View view){
        Intent intent = new Intent(DaftarPeta.this, PetaDasar.class);
        startActivity(intent);
    }
    public void peta_sintetic(View view){
        Intent intent = new Intent(DaftarPeta.this, PetaSintetic.class);
        startActivity(intent);
    }
    public void peta_analitic(View view){
        Intent intent = new Intent(DaftarPeta.this, PetaJalan.class);
        startActivity(intent);
    }

}
