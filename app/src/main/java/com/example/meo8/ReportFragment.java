package com.example.me08;

import android.app.DatePickerDialog;
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

//Fragment to view pie chart and bar chart
public class ReportFragment extends Fragment {

    private Calendar calendar;
    private Button mbuttonpiechart;
    private Button mbuttonbarchart;
    private int year, month, day;
    private EditText mStartDate;
    private PieChart mPieChart;
    private BarChart mBarChart;
    String compword="[]";
    String id=null;
    int sum=0;
    private EditText mEndDate;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    String startdate=null;
    String enddate=null;
    List<String> suburbs=new ArrayList<String>();
    ArrayList<String> months=new ArrayList<String>();
    List<Integer> count=new ArrayList<Integer>();
    List<Integer> totalcount=new ArrayList<Integer>();
    Spinner sp;
    String yearspinner=null;
    APIGatewayConnection networkConnection=null;
    public ReportFragment() {
    }

    boolean val=false;
    @Nullable
    @Override

public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_report, container, false);

       networkConnection=new APIGatewayConnection();

        return view;
    }
   private class MammalsInfo extends AsyncTask<String, Void, String> {
       @Override
       protected String doInBackground(String... params) {
           Log.i("json ", "debugging");

           return (networkConnection.getMammalsByCategory());

       }

       @Override
       protected void onPostExecute(String result) {
           if (result.equalsIgnoreCase(compword)) {
               Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
           } else {
               try {
                   loadintopiechart(result);
               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
       }


       //load movies watched per suburb to pie chart
       public void loadintopiechart(String json) throws JSONException {
           List<PieEntry> entries = new ArrayList<>();
           JSONArray jsonArray = new JSONArray(json);
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject obj = jsonArray.getJSONObject(i);
               String suburb = obj.getString("SUBURB");
               suburbs.add(suburb);
               int val = obj.getInt("TOTALCOUNT");
               count.add(val);
               sum += val;
           }
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject obj = jsonArray.getJSONObject(i);
               entries.add(new PieEntry((count.get(i) * 100) / sum, suburbs.get(i)));


           }
           mPieChart.setVisibility(View.VISIBLE);
           mPieChart.animateXY(3000, 3000);
           PieDataSet piedataset = new PieDataSet(entries, "Movies watched per suburb");
           piedataset.setColors(ColorTemplate.COLORFUL_COLORS);
           PieData piedata = new PieData(piedataset);
           piedata.setValueFormatter(new PercentFormatter());
           System.out.println(piedata);
           mPieChart.setData(piedata);
           Description desc = new Description();
           desc.setText("Movies watched per suburb");
           mPieChart.setDescription(desc);
           mPieChart.invalidate();
       }

       //load movies watched per month to bar chart
       public void loadintobarchart(String json) throws JSONException {
           ArrayList<BarEntry> entries = new ArrayList<>();
           int barsum = 0;
           JSONArray jsonArray = new JSONArray(json);
           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject obj = jsonArray.getJSONObject(i);
               months.add(obj.getString("MONTH"));
               int intmonth = getCategory(obj.getString("MONTH"));
               int count = Integer.parseInt(obj.optString("TOTALCOUNT"));
               entries.add(new BarEntry((float) intmonth, count));
           }
           BarDataSet bardataset = new BarDataSet(entries, "Movies watched per month");
           bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
           BarData bardata = new BarData(bardataset);
           bardata.setBarWidth(0.9f);
           mBarChart.setVisibility(View.VISIBLE);
           mBarChart.animateY(3000);
           mBarChart.setData(bardata);
           XAxis xaxis = mBarChart.getXAxis();
           xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
           xaxis.setDrawGridLines(false);
           xaxis.setGranularity(1f);
           xaxis.setValueFormatter(new IAxisValueFormatter() {
               @Override
               public String getFormattedValue(float value, AxisBase axis) {
                   return months.get((int) value);
               }
           });
           mBarChart.setFitBars(true);
           YAxis yAxis = mBarChart.getAxisLeft();
           yAxis.setLabelCount(12, false);
           yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
           yAxis.setSpaceTop(15f);
           ;
           yAxis.setAxisMinimum(0f);
           Description desc = new Description();
           desc.setPosition(-50, -1000);
           desc.setText("Movies watched per month");
           mBarChart.setDescription(desc);
           mBarChart.invalidate();


       }

       //method to convert month value to int
       private int getCategory(String month) {

           if (month.equalsIgnoreCase("january"))
               return 1;
           else if (month.equalsIgnoreCase("february"))
               return 2;
           else if (month.equalsIgnoreCase("march"))
               return 3;
           else if (month.equalsIgnoreCase("april"))
               return 4;
           else if (month.equalsIgnoreCase("may"))
               return 5;
           else if (month.equalsIgnoreCase("june"))
               return 6;
           else if (month.equalsIgnoreCase("july"))
               return 7;
           else if (month.equalsIgnoreCase("august"))
               return 8;
           else if (month.equalsIgnoreCase("september"))
               return 9;
           else if (month.equalsIgnoreCase("october"))
               return 10;
           else if (month.equalsIgnoreCase("november"))
               return 11;
           else if (month.equalsIgnoreCase("december"))
               return 12;
           else return 0;

       }

   }}
