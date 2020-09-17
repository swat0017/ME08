package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.PieChart;

public class AboutUsFragment extends Fragment {
    public AboutUsFragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutus_layout, container, false);

        return  view;
    }
}
