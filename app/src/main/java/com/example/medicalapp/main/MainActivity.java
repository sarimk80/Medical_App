package com.example.medicalapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.medicalapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /**
     * THIS IS THE MAIN ACTIVITY
     * THIS ACTIVITY JOB IS TO DISPLAY THE BOTTOM NAVIGATION BAR
     **/

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bar_btm);

        /**
         * NAV HOST FRAGMENT IS TO FIND THE ACTIVITY WITH A FRAGMENT OF ID nav_host_fragmen
         * NAVIGATION UI SETUP THE BOTTOM NAVIGATION BAR
         */

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }
}
