package com.medical.medicalapp.map.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * We are foursquare api for the network call
 * after the call is made and the json data is fetch we are then converting
 * the json data to java object and then converting the java object to rxjava
 */
public class RetroClass {
    private static final String BASE_URL = "https://api.foursquare.com/v2/venues/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static APIService getApiService() {
        return getRetrofitInstance().create(APIService.class);
    }
}
