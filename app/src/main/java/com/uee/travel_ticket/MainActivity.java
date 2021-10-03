package com.uee.travel_ticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        if (savedInstanceState == null) {
//            Intent intent = new Intent(MainActivity.this, SplashScreenActivity.class);
//            startActivity(intent);
//
////            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
////                    new HomeFragment()).commit();
////            navigationView.setCheckedItem(R.id.nav_home);
//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.splash:
                Intent intent = new Intent(MainActivity.this, HomeFragment.class);
                startActivity(intent);
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_journey:
                Intent intent1 = new Intent(getApplicationContext(), AllJourneysActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_All_journey:
                Intent intent6 = new Intent(getApplicationContext(), AllJourneysActivity.class);
                startActivity(intent6);
                break;
            case R.id.nav_profile:
                Intent intent3 = new Intent(getApplicationContext(), UserProfileActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_payment:
                Intent intent4 = new Intent(getApplicationContext(), PaymentInformationActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_acc_balance:
                Intent intent5 = new Intent(getApplicationContext(), CreditActivity.class);
                startActivity(intent5);
                break;
            case R.id.nav_login:
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_rate:
                Toast.makeText(this, "send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

}