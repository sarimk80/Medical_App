package com.medical.medicalapp.map.model;

public class Feature {
    private String cc;//": "PK",
    private String name;//": "Karachi",
    private String displayName;//": "Karachi, Pakistan",
    private String matchedName;//": "Karachi, Pakistan",
    private String highlightedName;//": "<b>Karachi</b>, Pakistan",
    private int woeType;//": 7,
    private String slug;//": "karachi",
    private String id;//": "geonameid:1174872",
    private String longId;//": "72057594039102808",

    public Feature(String cc, String name, String displayName, String matchedName, String highlightedName, int woeType, String slug, String id, String longId) {
        this.cc = cc;
        this.name = name;
        this.displayName = displayName;
        this.matchedName = matchedName;
        this.highlightedName = highlightedName;
        this.woeType = woeType;
        this.slug = slug;
        this.id = id;
        this.longId = longId;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMatchedName() {
        return matchedName;
    }

    public void setMatchedName(String matchedName) {
        this.matchedName = matchedName;
    }

    public String getHighlightedName() {
        return highlightedName;
    }

    public void setHighlightedName(String highlightedName) {
        this.highlightedName = highlightedName;
    }

    public int getWoeType() {
        return woeType;
    }

    public void setWoeType(int woeType) {
        this.woeType = woeType;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }
}
