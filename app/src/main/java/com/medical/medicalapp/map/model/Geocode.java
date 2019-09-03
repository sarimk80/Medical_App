package com.medical.medicalapp.map.model;

public class Geocode {
    private String what;//": "",
    private String where;//": "karachi",
    private Feature feature;//": {

    public Geocode(String what, String where, Feature feature) {
        this.what = what;
        this.where = where;
        this.feature = feature;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
