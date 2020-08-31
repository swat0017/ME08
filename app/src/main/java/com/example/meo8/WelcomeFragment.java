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
                    ReportFragment mammalFragment=new ReportFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ReportFragment()).addToBackStack(null).commit();
                }});
             furthercard = (CardView)view.findViewById(R.id.infocard);
            furthercard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    InformationFragment mammalFragment=new InformationFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new InformationFragment()).addToBackStack(null).commit();
                }});
            return view;

        }}
