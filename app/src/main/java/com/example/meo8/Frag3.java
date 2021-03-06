package com.example.me08;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.me08.DataVisualisation.Charts;
import com.example.me08.DataVisualisation.Pie;
import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Frag3 extends androidx.fragment.app.Fragment {

    private BarChart mPieChart;

    String compword="[]";


    APIGatewayConnection networkConnection=null;
    public Frag3() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vulnerable_fragment, container, false);
        mPieChart=(BarChart) view.findViewById(R.id.piechartvulnerable);
        // mBarChart=(BarChart) view.findViewById(R.id.barchartsec);
        networkConnection=new APIGatewayConnection();
       Vulnerable info=new Vulnerable();
        info.execute();
        return  view;
    }
    private class Vulnerable extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getVulnerableResult());

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    Charts.loadintoBarchart(result,mPieChart);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
