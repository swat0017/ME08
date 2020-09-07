package com.example.me08;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;

public class MainActivity  extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adding the toolbar

        drawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nv);
        View header=navigationView.getHeaderView(0);
        TextView txtdate=(TextView)header.findViewById(R.id.nav_date);
        long date=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String currentdate=sdf.format(date);

        txtdate.setText(currentdate);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        toggle = new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {

            WelcomeFragment homeActivity=new WelcomeFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WelcomeFragment()).addToBackStack(null).commit();

        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Bundle data=new Bundle();

        //Navigation to various fragments
        switch (item.getItemId()) {


            case R.id.start:
                //list of movies in memoir
                WelcomeFragment memoirFragment=new WelcomeFragment();
                memoirFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WelcomeFragment()).addToBackStack(null).commit();

           case R.id.prelims:
                //watchlist fragment
                PrelimnaryResultsFragment watchlistFragment=new PrelimnaryResultsFragment();
                watchlistFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PrelimnaryResultsFragment()).addToBackStack(null).commit();
          /*      break;
            case R.id.report:
                //report fragment
                ReportFragment fragmentr=new ReportFragment();
                fragmentr.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReportFragment()).commit();
                break;
            case R.id.map:
                //map fragment
                MapsActivity fragment=new MapsActivity();
                fragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragment).commit();
                break;
                */

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }


}
