package com.example.meo8;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me08.MammalFragment;
import com.example.me08.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MortalityFragment extends Fragment {
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
    com.example.me08.networkconnection.APIGatewayConnection networkConnection=null;

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.postfiremortality_layout, container, false);
        //mPieChart=(PieChart) view.findViewById(R.id.piechart);
        mBarChart=(HorizontalBarChart) view.findViewById(R.id.barchart);
        networkConnection=new com.example.me08.networkconnection.APIGatewayConnection();
        MortalityFragment.MortalityInfo info=new MortalityFragment.MortalityInfo();
        info.execute();
        return  view;
    }
    private class MortalityInfo extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getMortalityResult());

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    com.example.me08.DataVisualisation.Charts.loadintoBarchart(result, mBarChart);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
