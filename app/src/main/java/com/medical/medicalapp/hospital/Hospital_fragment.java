package com.medical.medicalapp.hospital;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.medical.medicalapp.R;
import com.medical.medicalapp.databinding.FragmentHospitalFragmentBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class Hospital_fragment extends Fragment {

    /**
     * THIS IS THE FIRST FRAGMENT THE USER SEE WHEN HE/SHE LOGIN
     * THIS FRAGMENT DISPLAY THE LIST OF HOSPITALS OR AMBULANCES THAT THE USER AND CALL
     */


    private FragmentHospitalFragmentBinding fragmentHospitalFragmentBinding;

    public Hospital_fragment() {
        // Required empty public constructor
    }

    /**
     * OnCreateView will bind the layout with out fragment
     *
     * @param inflater           the layout with fragment
     * @param container
     * @param savedInstanceState
     * @return the view
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHospitalFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital_fragment, null, false);

        return fragmentHospitalFragmentBinding.getRoot();
//        return inflater.inflate(R.layout.fragment_hospital_fragment, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
         * Created an interface with the name od event_hospital which
         * contains all the click event for this fragment
         * and those void methods are then connected to the layout
         * and when the user click on those card view it triggers these
         * events
         */
        fragmentHospitalFragmentBinding.setEvent(new Events_hospital() {
            @Override
            public void Edhi() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:115"));

                startActivity(callAction);
            }

            @Override
            public void Chippa() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:1020"));

                startActivity(callAction);
            }

            @Override
            public void Jinnah() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199201300"));

                startActivity(callAction);

            }

            @Override
            public void Abbasi() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199260400"));

                startActivity(callAction);

            }

            @Override
            public void civil() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199215740"));

                startActivity(callAction);

            }

            @Override
            public void Ojah() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199232660"));

                startActivity(callAction);

            }

            @Override
            public void CancerFoundation() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199232660"));

                startActivity(callAction);
            }

            @Override
            public void RabMedical() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199215740"));

                startActivity(callAction);
            }

            @Override
            public void Ashfaq_Memorial() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199201300"));

                startActivity(callAction);
            }

            @Override
            public void Al_Mustafa() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199260400"));

                startActivity(callAction);
            }

            @Override
            public void Aga_Khan() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199201300"));

                startActivity(callAction);
            }

            @Override
            public void Liaquat_National() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199215740"));

                startActivity(callAction);
            }

            @Override
            public void Ahmed_Ibrahim() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199215740"));

                startActivity(callAction);
            }

            @Override
            public void Shifa_Sugar_Clinic() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199260400"));

                startActivity(callAction);
            }

            @Override
            public void National_Health() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199260400"));

                startActivity(callAction);
            }

            @Override
            public void Darul_Sehat() {
                Intent callAction = new Intent(Intent.ACTION_DIAL);
                callAction.setData(Uri.parse("tel:02199260400"));

                startActivity(callAction);
            }
        });


    }
}
