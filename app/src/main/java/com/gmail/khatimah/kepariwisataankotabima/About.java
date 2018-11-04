package com.gmail.khatimah.kepariwisataankotabima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {
    private TextView txtket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String title = getIntent().getStringExtra("TITLE");
        String ket = getIntent().getStringExtra("DESC");

        getSupportActionBar().setTitle(title);

        txtket = (TextView) findViewById(R.id.ket);
        txtket.setText(ket);
    }
}
