package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.me08.adapter.ViewCategoryAdapter;
import com.example.me08.adapter.ViewPageAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;


public class WelcomeFragment extends Fragment {
        Button analysis;
        Button organisation;
        Button maplayout;
        CardView categoryCard;
        CardView speciesCard;
        CardView prepostcard;
        CardView findCard;
    private ViewCategoryAdapter viewPageAdapter;
    private ViewPager viewPager;
    WormDotsIndicator sp;
    boolean val=false;
        public WelcomeFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);}
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.welcome_fragment, container, false);
            sp=(WormDotsIndicator)view.findViewById(R.id.dotswelcome);
            viewPager=(ViewPager)view.findViewById(R.id.viewpagewelcome);
            viewPageAdapter=new ViewCategoryAdapter(getChildFragmentManager());
            viewPager.setAdapter(viewPageAdapter);
            sp.setViewPager(viewPager);
          /*  categoryCard=(CardView)view.findViewById(R.id.categoryrisk);
          categoryCard.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                          new InformationFragment()).addToBackStack(null).commit();
          }
        });*/
            speciesCard=(CardView)view.findViewById(R.id.speciesrisk);
            speciesCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReportFragment reportFragment=new ReportFragment();

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ReportFragment()).addToBackStack(null).commit();
                }
            });
            findCard=(CardView)view.findViewById(R.id.infocard);
            findCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PrelimnaryResultsFragment prelimnaryResultsFragment=new PrelimnaryResultsFragment();

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new PrelimnaryResultsFragment()).addToBackStack(null).commit();
                }
            });
          /*  prepostcard=(CardView)view.findViewById(R.id.prepostcard);
            prepostcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    com.example.meo8.MortalityFragment mortalityFragment=new com.example.meo8.MortalityFragment();

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new com.example.meo8.MortalityFragment()).addToBackStack(null).commit();
                }
            });*/

                   return view;

        }}
