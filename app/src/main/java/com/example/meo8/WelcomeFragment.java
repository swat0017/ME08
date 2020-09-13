package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


    public class WelcomeFragment extends Fragment {




        ArrayAdapter<String> arrayAdapter;
        ArrayAdapter<String> arrayAdapter2;
        ArrayAdapter<String> arrayAdapter3;
        CardView speciescard;
        CardView furthercard;
        public WelcomeFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);}
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.activity_welcome, container, false);
            speciescard=(CardView)view.findViewById(R.id.species);
            speciescard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    com.example.me08.ReportFragment mammalFragment=new com.example.me08.ReportFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new com.example.me08.ReportFragment()).addToBackStack(null).commit();
                }});
             furthercard = (CardView)view.findViewById(R.id.infocard);
            furthercard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    com.example.me08.InformationFragment mammalFragment=new com.example.me08.InformationFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new com.example.me08.InformationFragment()).addToBackStack(null).commit();
                }});
            return view;

        }}
