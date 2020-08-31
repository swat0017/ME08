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

import com.example.me08.networkconnection.APIGatewayConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InformationFragment extends Fragment { String compword="[]";
    View view =null;
    APIGatewayConnection networkConnection=null;
    public InformationFragment() {
    }

    public void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);}
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.furtherinfo_layout, container, false);

        networkConnection=new APIGatewayConnection();
       FurtherInfo info=new FurtherInfo();
        info.execute();
        return  view;
    }
    private class FurtherInfo extends AsyncTask<String, Void, String> {
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
                        result = obj.getString("FurtherInformation");
                        TextView text = view.findViewById(R.id.further);
                        Log.i("result",result);
                        text.setText(result);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
