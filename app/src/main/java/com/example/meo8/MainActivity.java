//Created by:Swathy Chandran
// Date:28-08-2020
package com.example.me08;

import android.os.Bundle;
import android.view.MenuItem;

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

        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {

            WelcomeFragment homeActivity=new WelcomeFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WelcomeFragment()).commit();

        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Bundle data=new Bundle();
        String username =getIntent().getStringExtra("username");

        String id =getIntent().getStringExtra("id");
        data.putString("username",username);
        data.putString("id",id);
        //Navigation to various fragments
        switch (item.getItemId()) {
            case R.id.species:
                //Fire species Fragment
                ReportFragment reportFragment=new ReportFragment();
                reportFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReportFragment()).commit();
                break;

          /*  case R.id.moviememoir:
                //list of movies in memoir
                MemoirFragment memoirFragment=new MemoirFragment();
                memoirFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MemoirFragment()).commit();
                break;
            case R.id.watchlist:
                //watchlist fragment
                WatchlistFragment watchlistFragment=new WatchlistFragment();
                watchlistFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WatchlistFragment()).commit();
                break;
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

   /* @Override

   private void replaceFragment(MovieSearch nextFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.content_frame, nextFragment);
        fragmentTransaction.commit();
    }*/
}
