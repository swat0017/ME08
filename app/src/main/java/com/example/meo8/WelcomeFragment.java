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


    public class WelcomeFragment extends Fragment {
        Button analysis;
        Button organisation;
        Button maplayout;
        public WelcomeFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);}
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.welcome_fragment, container, false);
           analysis=(Button)view.findViewById(R.id.buttonanalysis);
            maplayout=(Button)view.findViewById(R.id.buttonloc);
            organisation=(Button)view.findViewById(R.id.buttonorg);
           analysis.setOnClickListener((new View.OnClickListener() {
               @Override
               public void onClick(View view) {

              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                           new RiskAnalysisFragment()).addToBackStack(null).commit();


               }}));


            maplayout.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MapFragment()).addToBackStack(null).commit();


                }}));

            organisation.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new OrganisationviewFragment()).addToBackStack(null).commit();


                }}));
                   return view;

        }}
