package com.example.sansigolo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MarkerList markers = new MarkerList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        markers.getMarkers();

        List<String> descriptionName = markers.AllMarkers();

        ArrayAdapter<String> adapterMarker = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, descriptionName);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapterMarker);
    }
    public void changeActivity (View view){
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(i);
    }
}
