package com.medical.medicalapp.map.model;

import java.util.ArrayList;

public class Venues {
    private String id;//": "4d84a792af642c0f87d8fcb0",
    private String name;//": "NIBD",
    private Location location;//":
    private ArrayList<Categories> categories;
    private String referralId;//": "v-1561362502",
    private boolean hasPerk;//": false

    public Venues(String id, String name, Location location, ArrayList<Categories> categories, String referralId, boolean hasPerk) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.categories = categories;
        this.referralId = referralId;
        this.hasPerk = hasPerk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public boolean isHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(boolean hasPerk) {
        this.hasPerk = hasPerk;
    }
}
