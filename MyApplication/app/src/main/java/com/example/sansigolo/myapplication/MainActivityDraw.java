package com.example.sansigolo.myapplication;

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

public class MainActivityDraw extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MarkerList markers = new MarkerList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String descriptionName = spinner.getSelectedItem().toString();
        Marker selectedMarker = markers.findMarkers(descriptionName);

        selectedMarker.getwikipedia();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
