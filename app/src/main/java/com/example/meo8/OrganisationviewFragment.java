package com.example.me08;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.me08.DataVisualisation.Pie;
import com.example.me08.adapter.OrganisationViewAdapter;
import com.example.meo8.entity.Organisation;



import com.example.me08.networkconnection.APIGatewayConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//Fragment to search movies
public class OrganisationviewFragment extends Fragment {
    String compword = "[]";

    public void OrganisationviewFragment() {
    }

    com.example.me08.adapter.OrganisationViewAdapter adapter;
    ArrayList<Organisation> arrayList;
    APIGatewayConnection apigatewayconnection;
    private EditText mSearch;
    String name;
    String address;
    String website;
    String image_path;
    Integer phoneNumber;
    String state;
    Spinner sp;
    String searchname;
    Button searchbutton;
    //ImageView image;
    ListView lv;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.organisationlist_view, container, false);
        apigatewayconnection = new APIGatewayConnection();

        mSearch = (EditText) view.findViewById(R.id.searchorg);
sp=(Spinner) view.findViewById(R.id.spinnerst);
        searchbutton = (Button) view.findViewById(R.id.searchorg_button);
        lv = (ListView) view.findViewById(R.id.listview1);
        SearchOrganisation search = new SearchOrganisation();
        search.execute();
        return view;
    }

    private class SearchOrganisation extends AsyncTask<String, Void, String> {
        ArrayList<Organisation> arrayList = new ArrayList<Organisation>();

        @Override
        protected String doInBackground(String... params) {

            return apigatewayconnection.getAllOrganisationList();

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    loadIntoListView(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //load organisation search results into list view
    private void loadIntoListView(String json) throws JSONException {

        arrayList = new ArrayList<Organisation>();
        JSONObject object = new JSONObject(json);
        JSONArray jsonArray = object.getJSONArray("body");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            name = obj.getString("Name");
            address = obj.getString("Address");
            website = obj.getString("Website");
            phoneNumber = obj.getInt("PhoneNumber");
            state = obj.getString("State");
            image_path = obj.getString("ImageLink");

            Organisation org = new Organisation(name, address, state, phoneNumber, website, image_path);
            arrayList.add(org);
            Toast.makeText(getActivity().getApplicationContext(), "Successfully retrieved organisations", Toast.LENGTH_LONG).show();


        }

        adapter = new OrganisationViewAdapter(
                getActivity().getApplicationContext(), R.layout.listview_org, arrayList
        );
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setAdapter(adapter);
        lv.setFocusable(false);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Organisation m = (Organisation) lv.getItemAtPosition(position);
                name = m.getName();
                phoneNumber = m.getPhoneNumber();
                website = m.getWebsite();
                address = m.getAddress();
                state = m.getState();
                image_path=m.getImage();
                if (!name.isEmpty()) {
                    SharedPreferences sharedPref = getActivity().
                            getSharedPreferences("Message", Context.MODE_PRIVATE);
                    SharedPreferences.Editor spEditor = sharedPref.edit();
                    spEditor.putString("Name", name);
                    spEditor.putString("Website", website);
                    spEditor.putString("Address", address);
                    spEditor.putInt("PhoneNumber", phoneNumber);
                    spEditor.putString("State", state);
                    spEditor.putString("Image", image_path);
                    spEditor.apply();
                }


                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new In_Org_Fragment()).addToBackStack(null).commit();


            }

        });
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state=sp.getSelectedItem().toString();
                searchname = mSearch.getText().toString();
                SearchIndividual searchval = new SearchIndividual();
                searchval.execute(state);
            }
        });
    }

    private class SearchIndividual extends AsyncTask<String, Void, String> {
        ArrayList<Organisation> arrayList = new ArrayList<Organisation>();

        @Override
        protected String doInBackground(String... params) {

            return apigatewayconnection.getOrgLocation(state);

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No info", Toast.LENGTH_LONG).show();
            } else {
                try {
                    loadIntoListViewSearch(result, searchname);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //load organisation search results into list view
    private void loadIntoListViewSearch(String json, String searchname) throws JSONException {

        arrayList = new ArrayList<Organisation>();
        JSONObject object = new JSONObject(json);
        JSONArray jsonArray = object.getJSONArray("body");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            name = obj.getString("Name");
            address = obj.getString("Address");
            website = obj.getString("Website");
            phoneNumber = obj.getInt("PhoneNumber");
            state = obj.getString("State");
            image_path = obj.getString("ImageLink");
            if(!searchname.isEmpty()){
            if(name.toLowerCase().contains(searchname.toLowerCase())){

            Organisation org = new Organisation(name, address, state, phoneNumber, website, image_path);
            arrayList.add(org);
            Toast.makeText(getActivity().getApplicationContext(), "Successfully retrieved organisations", Toast.LENGTH_LONG).show();


        }
            else{
               // Toast.makeText(getActivity().getApplicationContext(), "No matching org found", Toast.LENGTH_LONG).show();
            }
        }
            else{

                Organisation org = new Organisation(name, address, state, phoneNumber, website, image_path);
                arrayList.add(org);
                Toast.makeText(getActivity().getApplicationContext(), "Successfully retrieved organisations", Toast.LENGTH_LONG).show();


            }




        }

        adapter = new OrganisationViewAdapter(
                getActivity().getApplicationContext(), R.layout.listview_org, arrayList
        );
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setAdapter(adapter);
        lv.setFocusable(false);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Organisation m = (Organisation) lv.getItemAtPosition(position);
                name = m.getName();
                phoneNumber = m.getPhoneNumber();
                website = m.getWebsite();
                address = m.getAddress();
                state = m.getState();
                image_path=m.getImage();
                if (!name.isEmpty()) {
                    SharedPreferences sharedPref = getActivity().
                            getSharedPreferences("Message", Context.MODE_PRIVATE);
                    SharedPreferences.Editor spEditor = sharedPref.edit();
                    spEditor.putString("Name", name);
                    spEditor.putString("Website", website);
                    spEditor.putString("Address", address);
                    spEditor.putInt("PhoneNumber", phoneNumber);
                    spEditor.putString("State", state);
                    spEditor.putString("Image", image_path);
                    spEditor.apply();
                }


                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new In_Org_Fragment()).addToBackStack(null).commit();


            }

        });

    }
       }









