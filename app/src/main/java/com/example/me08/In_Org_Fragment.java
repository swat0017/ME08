package com.example.me08;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me08.DataVisualisation.Charts;
import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
public class In_Org_Fragment extends Fragment {
    private Button mbuttonpiechart;
    private Button mbuttonbarchart;
    private int year, month, day;
    private PieChart mPieChart;
    private BarChart mBarChart;
    String compword="[]";
    String id=null;
    int sum=0;

    ArrayList<String> organzation = new ArrayList<String>();
    //List<String> orgname = new ArrayList<String>();
    //ArrayList<String> address=new ArrayList<String>();
    //ArrayList<String> number=new ArrayList<String>();
    //ArrayList<String> Website=new ArrayList<String>();
    APIGatewayConnection networkConnection=null;
    private TextView tvAddress;
    private TextView tvPhone;
    private TextView tvWebsite;
    private TextView tvEmail;
    private ImageView tvImage;
    private ImageView tvBack;

    public In_Org_Fragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.in_org_layout, container, false);
        mPieChart=(PieChart) view.findViewById(R.id.piechart);
        tvAddress = view.findViewById(R.id.tv_address_detail);
        tvPhone = view.findViewById(R.id.tv_phone_detail);
        tvWebsite = view.findViewById(R.id.tv_website_detail);
        tvEmail = view.findViewById(R.id.tv_email_detail);
        tvImage = view.findViewById(R.id.image_org);
        tvBack = view.findViewById(R.id.iv_back);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
        //  mBarChart=(BarChart) view.findViewById(R.id.barchartsec);
        networkConnection=new APIGatewayConnection();
        In_Org_Fragment.OrgInfo info=new In_Org_Fragment.OrgInfo();
        info.execute();
        return  view;
    }
    private class OrgInfo extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            Log.i("json ", "debugging");

            return (networkConnection.getOrganzationResult());

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


    }

}
