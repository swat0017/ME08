package com.example.me08;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me08.DataVisualisation.Charts;
import com.example.me08.DataVisualisation.Pie;
import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class    InformationFragment extends Fragment { String compword="[]";
    View view =null;
    private PieChart mPieChart1;

    private PieChart mPieChart2;

    private PieChart mPieChart3;

    APIGatewayConnection networkConnection=null;
    public InformationFragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.furtherinfo_layout, container, false);
        mPieChart1=(PieChart) view.findViewById(R.id.piechartcritical);
        mPieChart2=(PieChart) view.findViewById(R.id.piechartendangered);
        mPieChart3=(PieChart) view.findViewById(R.id.piechartvulnerable);

        networkConnection=new APIGatewayConnection();
       FurtherInfo info=new FurtherInfo();
        info.execute();
        return  view;
    }
    private class FurtherInfo extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getCriticalResult());

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    Pie.loadintopiechart(result,mPieChart1);
                    Endangered end=new Endangered();
                    end.execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                }


            }
        }
    private class Endangered extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getEndangeredResult());

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    Pie.loadintopiechart(result,mPieChart2);
                    Vulnerable v=new Vulnerable();
                    v.execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }
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
                    Pie.loadintopiechart(result,mPieChart3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }
    }



    }

