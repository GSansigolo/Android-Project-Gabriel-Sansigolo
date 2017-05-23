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

-----------------------------------------------------------------------------------------------

    
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Selecione o local que você deseja acessar:"
        android:id="@+id/textView"
        android:layout_alignParentTop="true"
        android:layout_alignParentStart="true"
        android:textSize="16sp"
        android:textStyle="normal|bold" />

    <Spinner
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView"
        android:layout_alignParentStart="true"
        android:id="@+id/spinner" />

    <Button
        android:text="Abrir no Mapa"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/btn_maps"
        android:layout_below="@+id/spinner"
        android:layout_alignParentStart="true"
        android:layout_marginTop="16dp"
        android:layout_alignParentEnd="true"
        android:onClick="changeActivity"/>

    <Button
        android:text="Onde eu Estou"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="26dp"
        android:id="@+id/btn_gps1"
        android:onClick="changeActivity2"/>