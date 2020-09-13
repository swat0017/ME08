package com.example.me08;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

//Fragment to navigate to eah individual frame
public class ReportFragment extends Fragment {
 CardView mammal_card;
    CardView bird_card;
    CardView reptile_card;
    CardView spider_card;
    CardView fish_card;
    CardView frog_card;
    CardView insect_card;
    CardView info_card;

    private EditText mEndDate;

    public ReportFragment() {
    }

    boolean val=false;
    @Nullable
    @Override

public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_report, container, false);
        mammal_card=(CardView)view.findViewById(R.id.mammal_card);
         fish_card=(CardView)view.findViewById(R.id.fish_card);
         insect_card=(CardView)view.findViewById(R.id.insect_card);
         reptile_card=(CardView)view.findViewById(R.id.reptile_card);
        spider_card=(CardView)view.findViewById(R.id.spider_card);
        frog_card=(CardView)view.findViewById(R.id.frog_card);
        bird_card=(CardView)view.findViewById(R.id.bird_card);
        info_card=(CardView)view.findViewById(R.id.info_card);

        mammal_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MammalFragment mammalFragment=new MammalFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MammalFragment()).addToBackStack(null).commit();
            }});

        reptile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReptileFragment reptileFragment=new ReptileFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReptileFragment()).addToBackStack(null).commit();
            }});
        fish_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FishFragment fishFragment=new FishFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FishFragment()).addToBackStack(null).commit();
            }});
        bird_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BirdFragment birdFragment=new BirdFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BirdFragment()).addToBackStack(null).commit();
            }});
        spider_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpiderFragment spiderFragment=new SpiderFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SpiderFragment()).addToBackStack(null).commit();
            }});
        insect_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsectFragment insectFragment=new InsectFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InsectFragment()).addToBackStack(null).commit();
            }});
        frog_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrogFragment frogFragment=new FrogFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FrogFragment()).addToBackStack(null).commit();
            }});
        info_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrelimnaryResultsFragment prelimnaryResultsFragment=new PrelimnaryResultsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PrelimnaryResultsFragment()).addToBackStack(null).commit();
            }});
        return view;
    }

   }
