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
import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PrelimnaryResultsFragment extends Fragment {
    String compword="[]";
    View view =null;
            APIGatewayConnection networkConnection=null;
    public PrelimnaryResultsFragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.results_layout, container, false);

        networkConnection=new APIGatewayConnection();
        ResultsInfo info=new ResultsInfo();
        info.execute();
        return  view;
    }
    private class ResultsInfo extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getResult());

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                JSONObject object = null;

                try {
                    object = new JSONObject(result.toString());
                    JSONArray jsonArray = object.getJSONArray("body");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        result = obj.getString("PreliminaryResults");
                        TextView text = view.findViewById(R.id.findings);
                        Log.i("result",result);
                        text.setText(result);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }
    }}
