package com.example.sansigolo.myapplication;

/**
 * Created by Sansigolo on 25/03/2017.
 */

import java.util.List;
import java.util.LinkedList;

public class MarkerList {

    Connection connection = new Connection();
    List<Marker> markers = new LinkedList<Marker>();

    public void getMarkers() {
        try {
            markers = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> AllMarkers() {
        List<String> MarkersDesc = new LinkedList<String>();
        for (Marker m : markers) {
            MarkersDesc.add(m.getDescription());
        }
        return MarkersDesc;
    }

    public Marker findMarkers(String descriptionName) {
        for (Marker m : markers) {
            if (m.getDescription().equals(descriptionName)) {
                return m;
            }
        }
        return markers.get(0);
    }

}