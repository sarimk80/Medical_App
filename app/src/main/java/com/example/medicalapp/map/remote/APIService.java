package com.example.medicalapp.map.remote;

import com.example.medicalapp.map.model.Hospitals_location;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This interface is responsible for call the api service
 */
public interface APIService {
    @GET("search")
    Single<Hospitals_location> getLocation(
            @Query("near") String Near,
            @Query("categoryId") String categoryId,
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String v);
}
