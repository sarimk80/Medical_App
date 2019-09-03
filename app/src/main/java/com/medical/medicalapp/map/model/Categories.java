package com.medical.medicalapp.map.model;

public class Categories {

    private String id;//":"4bf58dd8d48988d196941735",
    private String name;//":"Hospital",
    private String pluralName;//":"Hospitals",
    private String shortName;//":"Hospital",
    //            "icon":{
//        "prefix":"https://ss3.4sqi.net/img/categories_v2/building/medical_",
//                "suffix":".png"
//    },
    private boolean primary;//":true

    public Categories(String id, String name, String pluralName, String shortName, boolean primary) {
        this.id = id;
        this.name = name;
        this.pluralName = pluralName;
        this.shortName = shortName;
        this.primary = primary;
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

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
