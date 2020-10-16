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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.me08.adapter.ViewPageAdapter;
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
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

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
    private ImageView back;
    private EditText mEndDate;

    public ReportFragment() {
    }
private ViewPageAdapter viewPageAdapter;
    private ViewPager viewPager;
    WormDotsIndicator sp;
    boolean val=false;
    @Nullable
    @Override

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_report, container, false);

sp=(WormDotsIndicator)view.findViewById(R.id.dots);
viewPager=(ViewPager)view.findViewById(R.id.viewpage);
viewPageAdapter=new ViewPageAdapter(getChildFragmentManager());
viewPager.setAdapter(viewPageAdapter);
sp.setViewPager(viewPager);
        back =view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WelcomeFragment welcomeFragment=new WelcomeFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WelcomeFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}