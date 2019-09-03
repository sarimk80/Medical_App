package com.medical.medicalapp.alarm;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.medical.medicalapp.R;
import com.medical.medicalapp.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Alarm_fragment extends Fragment {

    /**
     * THIS FRAGMENT IS RESPONSIBLE FOR SAVING DATA TO FIREBASE DATABASE
     * RETRIEVING DATA FROM THE DATABASE
     * SENDING SMS TO THE NUMBER THAT IS RETRIEVE FORM THE DATABASE
     * DISPLAYING CURRENT SIGN IN USER INFORMATION
     */

    private TextView name, email, phone, txt_phone_no;
    private Button btn_logout, btn_send_data, btn_send_sms;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private EditText edt_txt;


    public Alarm_fragment() {

    }

//    public static Alarm_fragment instance() {
//        return inst;
//    }


    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alarm_fragment, container, false);

        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        btn_logout = view.findViewById(R.id.btn_logout);
        txt_phone_no = view.findViewById(R.id.txt_phone_no);
        btn_send_data = view.findViewById(R.id.btn_send_data);
        btn_send_sms = view.findViewById(R.id.btn_Send_sms);
        edt_txt = view.findViewById(R.id.edt_phone);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Phone");

        final RxPermissions rxPermissions = new RxPermissions(getActivity());

        rxPermissions.request(Manifest.permission.SEND_SMS).subscribe(granted -> {
            if (granted) {

            } else {
                Toast.makeText(getContext(), "SMS Permission is required", Toast.LENGTH_LONG).show();
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            phone.setText(user.getPhoneNumber());
        } else {

        }
        btn_logout.setOnClickListener(view1 -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();

        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        btn_send_data.setOnClickListener(v -> SavePhoneNo());


        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                txt_phone_no.setText(String.valueOf(dataSnapshot.getValue()));
                final String latitude = "24.915706";
                final String longitude = "67.092954";
                btn_send_sms.setOnClickListener(v -> {
                    if (Objects.requireNonNull(dataSnapshot.getValue()).toString().isEmpty()) {
                        Toast.makeText(getContext(), "No Phone no. in database", Toast.LENGTH_LONG).show();
                    } else {
                        Send_SMS("I need your emergency help at http://maps.google.com/maps?q=" + latitude + "," + longitude,
                                dataSnapshot.getValue().toString());


                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        super.onResume();
    }

    private void SavePhoneNo() {
        String phone = edt_txt.getText().toString();
        if (!phone.isEmpty()) {
            databaseReference.setValue(phone);
            edt_txt.setText("");
        } else {
            Toast.makeText(getContext(), "Enter phone no.", Toast.LENGTH_LONG).show();
        }
    }


   private void Send_SMS(String user_location, String phone_no) {

        try {
            /*
            Calling the smsManager and smsManager contains a sendTextMassage
            method that do what the name suggest , it takes a phone no. and a string
            as message
             */
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone_no, null, user_location, null, null);

            Toast.makeText(getContext(), "SMS Send", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getContext(), "Could not SMS Send", Toast.LENGTH_LONG).show();
            Log.d("Alarm", e.toString());

        }

    }
}
