package com.example.medicalapp.map.model;

public class Hospitals_location {


    private Meta meta;
    //          ": {
//        "code": 200,
//                "requestId": "5d108046d69ed0002c110fed"
//    },
    private Response response;//": {

    public Hospitals_location(Meta meta, Response response) {
        this.meta = meta;
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}



