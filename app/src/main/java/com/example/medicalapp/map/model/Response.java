package com.example.medicalapp.map.model;

import java.util.ArrayList;

public class Response {
    private ArrayList<Venues> venues;
    private boolean confident;//": false,
    private Geocode geocode;//": {}

    public Response(ArrayList<Venues> venues, boolean confident, Geocode geocode) {
        this.venues = venues;
        this.confident = confident;
        this.geocode = geocode;
    }

    public ArrayList<Venues> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venues> venues) {
        this.venues = venues;
    }

    public boolean isConfident() {
        return confident;
    }

    public void setConfident(boolean confident) {
        this.confident = confident;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }
}
