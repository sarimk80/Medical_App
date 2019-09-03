package com.medical.medicalapp.map.model;

public class LabeledLatLngs {
    private String label;//":"display",
    private double lat;//":24.897570078253846,
    private double lng;//":67.07827091217041

    public LabeledLatLngs(String label, double lat, double lng) {
        this.label = label;
        this.lat = lat;
        this.lng = lng;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
}
