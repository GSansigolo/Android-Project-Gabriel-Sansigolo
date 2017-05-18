package com.example.sansigolo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity {

    MarkerList markers = new MarkerList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        markers.getMarkers();

        List<String> descriptionName = markers.AllMarkers();

        ArrayAdapter<String> adapterMarker = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, descriptionName);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapterMarker);
    }

    public void changeActivity (View view){

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String descriptionName = spinner.getSelectedItem().toString();
        Marker selectedMarker = markers.findMarkers(descriptionName);

        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        //i.putExtra() -> vou ter que colocar um extra pro nome, um pro lat e outro pro long...
        //ver link -> http://stackoverflow.com/questions/3913592/start-an-activity-with-a-parameter

        i.putExtra("descriptionName", (selectedMarker.getDescription()));
        i.putExtra("lat", (selectedMarker.getLat()));
        i.putExtra("lng", (selectedMarker.getLon()));

        startActivity(i);
    }

    public void changeActivity2 (View view){

        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        //i.putExtra() -> vou ter que colocar um extra pro nome, um pro lat e outro pro long...
        //ver link -> http://stackoverflow.com/questions/3913592/start-an-activity-with-a-parameter

        Double latitude = 0.0;
        Double longitude = 0.0;

        i.putExtra("descriptionName", ("Você Está Aqui."));
        i.putExtra("lat",latitude);
        i.putExtra("lng",longitude);

        startActivity(i);
    }
}
