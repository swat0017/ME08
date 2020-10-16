package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.PieChart;

public class AboutUsFragment extends Fragment {
    public AboutUsFragment() {
    }

    private ImageView back;
    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutus_layout, container, false);
        back =view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.me08.WelcomeFragment welcomeFragment=new com.example.me08.WelcomeFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new com.example.me08.WelcomeFragment()).addToBackStack(null).commit();
            }
        });
        return  view;
    }
}
