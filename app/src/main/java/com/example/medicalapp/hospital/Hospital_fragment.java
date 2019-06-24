package com.example.medicalapp.hospital;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medicalapp.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class Hospital_fragment extends Fragment {

    // private FragmentHospitalFragmentBinding fragmentHospitalFragmentBinding;

    public Hospital_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        fragmentHospitalFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital_fragment, null, false);
//
//        return fragmentHospitalFragmentBinding.getRoot();
        return inflater.inflate(R.layout.fragment_hospital_fragment, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        fragmentHospitalFragmentBinding.setEvent(new Events_hospital() {
//            @Override
//            public void Edhi() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:115"));
//
//                startActivity(callAction);
//            }
//
//            @Override
//            public void Chippa() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:1020"));
//
//                startActivity(callAction);
//            }
//
//            @Override
//            public void Jinnah() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:02199201300"));
//
//                startActivity(callAction);
//
//            }
//
//            @Override
//            public void Abbasi() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:02199260400"));
//
//                startActivity(callAction);
//
//            }
//
//            @Override
//            public void civil() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:02199215740"));
//
//                startActivity(callAction);
//
//            }
//
//            @Override
//            public void Ojah() {
//                Intent callAction = new Intent(Intent.ACTION_DIAL);
//                callAction.setData(Uri.parse("tel:02199232660"));
//
//                startActivity(callAction);
//
//            }
//        });


    }
}
