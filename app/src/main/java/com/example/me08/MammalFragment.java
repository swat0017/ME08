package com.example.me08;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me08.DataVisualisation.Charts;
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
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MammalFragment extends Fragment {
    private Button mbuttonpiechart;
    private Button mbuttonbarchart;
    private int year, month, day;
    private PieChart mPieChart;
    private BarChart mBarChart;
    String compword="[]";
    String id=null;
    int sum=0;
    List<String> animalCategorys=new ArrayList<String>();
    ArrayList<String> months=new ArrayList<String>();
    List<Integer> count=new ArrayList<Integer>();
    List<Integer> totalcount=new ArrayList<Integer>();
    APIGatewayConnection networkConnection=null;
    public MammalFragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mammal_layout, container, false);
        mPieChart=(PieChart) view.findViewById(R.id.piechart);
        //mBarChart=(BarChart) view.findViewById(R.id.barchartsec);
        networkConnection=new APIGatewayConnection();
        MammalsInfo info=new MammalsInfo();
        info.execute();
return  view;
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
                Charts.loadintopiechart(result,mPieChart);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}}
