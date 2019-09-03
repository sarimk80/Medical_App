package com.medical.medicalapp.map.model;

import java.util.ArrayList;

public class Location {
    private String address;//": "ST 2/A Block 17 Gulshan-e-Iqbal , KDA Scheme 24",
    private String crossStreet;//": "Sir Shah Muhammad Suleman Rd",
    private double lat;//": 24.897570078253846,
    private double lng;//": 67.07827091217041,
    private ArrayList<LabeledLatLngs> labeledLatLngs;//":[
    //
//    {
//        "label":"display",
//            "lat":24.897570078253846,
//            "lng":67.07827091217041
//    }
//],
    private String postalCode;//": "75300",
    private String cc;//": "PK",
    private String city;//": "Karachi",
    private String state;//": "Sindh",
    private String country;//": "Pakistan",

    public Location(String address, String crossStreet, double lat, double lng, ArrayList<LabeledLatLngs> labeledLatLngs, String postalCode, String cc, String city, String state, String country) {
        this.address = address;
        this.crossStreet = crossStreet;
        this.lat = lat;
        this.lng = lng;
        this.labeledLatLngs = labeledLatLngs;
        this.postalCode = postalCode;
        this.cc = cc;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public ArrayList<LabeledLatLngs> getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(ArrayList<LabeledLatLngs> labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
