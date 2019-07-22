package com.example.medicalapp.map;


import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medicalapp.R;
import com.example.medicalapp.map.model.Hospitals_location;
import com.example.medicalapp.map.remote.APIService;
import com.example.medicalapp.map.remote.RetroClass;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class Map_fragment extends Fragment implements
        OnMapReadyCallback, PermissionsListener {

    /**
     * THIS FRAGMENT DISPLAYS THE MAP WHICH IS FROM THE MAP BOX MAP API
     * THIS FRAGMENT WILL ALSO MAKE A NETWORK CALL AND WILL DISPLAY THE LIST OF -
     * - ALL THE HOSPITALS IN NEARBY AREA
     * USER CAN ALSO TAP ON A PARTICULAR HOSPITAL AND CAN MAKE A CALL TO THAT HOSPITAL
     */

    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;
    private MapView mapView;

    private Disposable disposable;
    private static final String TAG = "Map_fragment";
    private ProgressDialog progressDialog;

//    private static final String BASE_URL="https://api.foursquare.com/v2/venues/search?near=karachi&categoryId=4bf58dd8d48988d196941735&client_id=SH3OJEQWNAOVRSCG20NUYL1QWT04IXX1WLVGFUMC214KC3AJ&client_secret=REWQHQVRC4SIMOROF4TQX0FI1RGM0PPYGB4GDEHNGB0RAY5O&v=20190110";


    public Map_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Mapbox.getInstance(getContext(), "pk.eyJ1Ijoic2FyaW1rODAiLCJhIjoiY2pjdGVoMzk2MnIyNzJxcGc0aHdwamJnbyJ9._wNROP2agdv8fZG4hutDRw");

        View view = inflater.inflate(R.layout.fragment_map_fragment, container, false);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        mapView.getMapAsync(this);
        progressDialog = new ProgressDialog(getContext());


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        progressDialog.show();
        progressDialog.setMessage("Loading.......");
        final List<Double> _getlat = new ArrayList<>();
        final List<Double> _getlon = new ArrayList<>();
        final List<String> _getTitle = new ArrayList<>();
        final List<String> _getSnippit = new ArrayList<>();

        Map_fragment.this.mapboxMap = mapboxMap;

        APIService apiService = RetroClass.getApiService();
        Single<Hospitals_location> locationSingle = apiService.getLocation("Karachi"
                , "4bf58dd8d48988d196941735",
                "SH3OJEQWNAOVRSCG20NUYL1QWT04IXX1WLVGFUMC214KC3AJ",
                "REWQHQVRC4SIMOROF4TQX0FI1RGM0PPYGB4GDEHNGB0RAY5O",
                "20190110").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        locationSingle.subscribe(new SingleObserver<Hospitals_location>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onSuccess(final Hospitals_location hospitals_location) {


                Log.d(TAG, "onSuccess: " + hospitals_location.getResponse().getVenues()
                        .get(0).getLocation().getLat());
                for (int i = 0; i < hospitals_location.getResponse().getVenues().size(); i++) {
                    _getlat.add(hospitals_location.getResponse().getVenues().get(i).getLocation()
                            .getLat());
                    _getlon.add(hospitals_location.getResponse().getVenues().get(i).getLocation()
                            .getLng());
                    _getTitle.add(hospitals_location.getResponse().getVenues().get(i).getName());
                    _getSnippit.add(hospitals_location.getResponse().getVenues().get(i).getLocation().getAddress());
                    mapboxMap.addMarker(new MarkerOptions().
                            position(new LatLng(_getlat.get(i), _getlon.get(i)))
                            .title(_getTitle.get(i)).snippet(_getSnippit.get(i)));

                }
                progressDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }
        });


//        _getlat.add(24.909608);
//        _getlon.add(67.084517);
//        _getTitle.add("Ashfaq Memorial Hospital");
//
//        _getlat.add(24.944148);
//        _getlon.add(67.137243);
//        _getTitle.add("OJHA Hospital");
//
//        _getlat.add(24.859248);
//        _getlon.add(67.010141);
//        _getTitle.add("Civil Hospital");
//
//        _getlat.add(24.920231);
//        _getlon.add(67.029736);
//        _getTitle.add("Abbasi Shaheed Hospital");
//
//        _getlat.add(24.850091);
//        _getlon.add(67.045451);
//        _getTitle.add("Jinnah Hospital");
//
//        _getlat.add(24.891065);
//        _getlon.add(67.074766);
//        _getTitle.add("Agha Khan");
//
//
//        _getlat.add(24.890466);
//        _getlon.add(67.067133);
//        _getTitle.add("Liaquat National Hospital");
//
//        for (int i = 0; i < _getlat.size(); i++) {
//
//        }

//        mapboxMap.setStyle(Style.LIGHT);
//
        mapboxMap.setStyle(Style.LIGHT,
                new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        enableLocationComponent(style);

//                        List<Feature> markerCoordinates = new ArrayList<>();
//                        markerCoordinates.add(Feature.fromGeometry(
//                                Point.fromLngLat(-71.065634, 42.354950))); // Boston Common Park
//                        markerCoordinates.add(Feature.fromGeometry(
//                                Point.fromLngLat(-71.097293, 42.346645))); // Fenway Park
//                        markerCoordinates.add(Feature.fromGeometry(
//                                Point.fromLngLat(-71.053694, 42.363725)));
//
//                        style.addImage("my-marker-image", BitmapFactory.decodeResource(
//                                Map_fragment.this.getResources(), R.drawable.ic_location_on_black_24dp));
                    }
                });

    }


    @SuppressWarnings({"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
// Check if permissions are enabled and if not request
        if (PermissionsManager.areLocationPermissionsGranted(getContext())) {

// Get an instance of the component
            LocationComponent locationComponent = mapboxMap.getLocationComponent();

// Activate with options
            locationComponent.activateLocationComponent(getContext(), loadedMapStyle);

// Enable to make component visible
            locationComponent.setLocationComponentEnabled(true);

// Set the component's camera mode
            locationComponent.setCameraMode(CameraMode.TRACKING);

// Set the component's render mode
            locationComponent.setRenderMode(RenderMode.NORMAL);


        } else {
            mapboxMap.setCameraPosition(new CameraPosition
                    .Builder()
                    .target(new LatLng(24.850091, 67.029736))
                    .zoom(8)
                    .build());
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(getActivity());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(getContext(), "User Permission", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableLocationComponent(style);
                }
            });
        } else {
            Toast.makeText(getContext(), "Not Granted Permission", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        disposable.dispose();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mapView.onDestroy();
    }


}
