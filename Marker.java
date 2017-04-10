package com.example.sansigolo.myapplication;

/**
 * Created by Sansigolo on 06/03/2017.
 */

public class Marker {

    private Double lat;
    private Double lon;
    private String description;
    private String wikipedia;

    public Marker(Double lat, Double lng, String geoname, String url){
        this.lat = lat;
        this.lon = lng;
        this.description = geoname;
        this.wikipedia = wikipedia;
    }

    public String getwikipedia() {
        return wikipedia;
    }

    public void setwikipedia(String url) {
        this.wikipedia = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
