package com.example.medicalapp.alarm;


import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicalapp.R;
import com.example.medicalapp.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            phone.setText(user.getPhoneNumber());
        } else {

        }
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        btn_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavePhoneNo();
            }
        });


        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                txt_phone_no.setText(String.valueOf(dataSnapshot.getValue()));
                btn_send_sms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dataSnapshot.getValue().toString().isEmpty()) {
                            Toast.makeText(getContext(), "No Phone no. in database", Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + dataSnapshot.getValue().toString()));
                            intent.putExtra("sms_body", "Help!!!!!!");
                            startActivity(intent);

                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        super.onResume();
    }

    void SavePhoneNo() {
        String phone = edt_txt.getText().toString();
        if (!phone.isEmpty()) {
            databaseReference.setValue(phone);
            edt_txt.setText("");
        } else {
            Toast.makeText(getContext(), "Enter phone no.", Toast.LENGTH_LONG).show();
        }
    }
}
