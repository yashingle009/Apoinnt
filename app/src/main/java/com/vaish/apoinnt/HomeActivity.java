package com.vaish.apoinnt;

import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    private homepage homeFragment;
    private CategoryFragment categoryFragment;
    private AppointmentFragment appointmentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);;



//        fragmentManager = getSupportFragmentManager();
//        bottomNavigationView = findViewById(R.id.BottomNavigation);
//
//        homeFragment = new homepage();
//        categoryFragment = new CategoryFragment();
//        appointmentFragment = new AppointmentFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_main_layout, new homepage()).commit();

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.home_main_layout) {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.home_main_layout, homeFragment)
//                            .commit();
//                } else if (item.getItemId() == R.id.category) {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.home_main_layout, categoryFragment)
//                            .commit();
//                } else if (item.getItemId() == R.id.appointment) {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.home_main_layout, appointmentFragment)
//                            .commit();
//                }
//                return true;
//            }
//        });
//
//        fragmentManager.beginTransaction().replace(R.id.home_main_layout, homeFragment).commit();

        }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            if (id == R.id.home) {
                selectedFragment = new homepage();
            }
            if (id == R.id.category){
                selectedFragment = new CategoryFragment();

            }
            if (id==R.id.appointment){
                selectedFragment = new AppointmentFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.home_main_layout,selectedFragment).commit();
            return true;
        }};

}