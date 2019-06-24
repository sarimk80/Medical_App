package com.example.medicalapp.alarm;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.medicalapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Alarm_fragment extends Fragment {

    //    AlarmManager alarmManager;
//    private PendingIntent pendingIntent;
//    private TimePicker alarmTimePicker;
//    private static Alarm_fragment inst;
//    private TextView alarmTextView;
//    private Switch aSwitch;
//    Calendar calendar = null;
    TextView name, email, phone;


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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            phone.setText(user.getPhoneNumber());
        } else {

        }


//        alarmTimePicker = view.findViewById(R.id.Alarm);
//        alarmTextView = view.findViewById(R.id.alert);
//        aSwitch = view.findViewById(R.id.toggle);
//
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    Log.d("Main", "Alarm on");
//                    Intent myIntent = new Intent(getContext(), AlarmReceiver.class);
//                    pendingIntent = PendingIntent.getBroadcast(getContext(), 1, myIntent, 0);
//                    calendar = Calendar.getInstance();
//                    calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
//                    calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
//                    alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
//                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),10000, pendingIntent);
//
//                } else {
//                    alarmManager.cancel(pendingIntent);
//                    alarmTextView.setText("");
//                    Log.d("MyActivity", "Alarm Off");
//
//                }
//            }
//        });

        return view;
    }

//    public void setAlarmText(String alarmText) {
//        alarmTextView.setText(alarmText);
//    }

}
