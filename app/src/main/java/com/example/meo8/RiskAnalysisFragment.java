package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.meo8.MortalityFragment;

public class RiskAnalysisFragment extends Fragment {


    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapter3;
    CardView analysiscard;
    CardView findingscard;
    CardView categorycard;
    CardView prepostcard;


    public RiskAnalysisFragment() {
    }}

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bushfire_fragment, container, false);
        analysiscard=(CardView)view.findViewById(R.id.speciesrisk);
        findingscard=(CardView)view.findViewById(R.id.infocard);
        categorycard=(CardView)view.findViewById(R.id.categoryrisk);
        prepostcard=(CardView)view.findViewById(R.id.prepostcard);

        analysiscard.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReportFragment()).addToBackStack(null).commit();

            }}));
        categorycard.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InformationFragment()).addToBackStack(null).commit();


            }}));
        prepostcard.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MortalityFragment()).addToBackStack(null).commit();

            }}));
        findingscard.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PrelimnaryResultsFragment()).addToBackStack(null).commit();

            }}));
                return view;
                }}
    */