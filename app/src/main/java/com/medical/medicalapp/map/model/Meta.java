package com.medical.medicalapp.map.model;

public class Meta {
    private int code;//": 200,
    private String requestId;//": "5d108046d69ed0002c110fed"

    public Meta(int code, String requestId) {
        this.code = code;
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
