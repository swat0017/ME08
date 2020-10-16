package com.example.me08;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.me08.networkconnection.APIGatewayConnection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

//Map fragment showing user location and nearby top 5 animal welfare organisations location on google maps
//filter based on state is also given

public class MapFragment extends Fragment implements OnMapReadyCallback {
    public MapFragment() {
    }

    private GoogleMap mMap;
    APIGatewayConnection networkConnection;
    String compword = "[]";
    String state = null;
    Spinner sp;
    EditText address;
    Button search;
    double latitude;
    double longitude;
    LatLng latLng;
    Button nearby;
    private ImageView back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        networkConnection = new APIGatewayConnection();


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
       SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        sp=(Spinner)view.findViewById(R.id.stateSpinner) ;
        state = sp.getSelectedItem().toString();
        nearby=(Button)view.findViewById(R.id.nearby) ;
        address = (EditText) view.findViewById(R.id.address);
        search = (Button) view.findViewById(R.id.button_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = sp.getSelectedItem().toString();
                String addressval = address.getText().toString() + "," + state;
                //convert address to latitude longitude
                Geocoder geoloc = new Geocoder(getActivity(), Locale.ENGLISH);

                List<Address> addresslist = null;
                try {
                    addresslist = geoloc.getFromLocationName(addressval, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (addresslist.size() > 0) {
                    Address address = addresslist.get(0);
                     latitude = address.getLatitude();
                     longitude = address.getLongitude();
                     latLng = new LatLng(latitude, longitude);
                    //set markers for current location
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(addressval);
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    mMap.addMarker(markerOptions);
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(9));


                }

            }
        });
        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = sp.getSelectedItem().toString();
        GetTop3 getTop3 = new GetTop3();
        getTop3.execute();}});
        back =view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.me08.WelcomeFragment welcomeFragment=new com.example.me08.WelcomeFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new com.example.me08.WelcomeFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

    //to get cinema address and postcode
    public class GetTop3 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return networkConnection.getOrgLocation(state);

        }

        @Override
        protected void onPostExecute(String result) {
            if (result.equalsIgnoreCase(compword)) {
                Toast.makeText(getActivity().getApplicationContext(), "No Organisations nearby", Toast.LENGTH_LONG).show();
            } else {


                JSONArray jsonArray = null;
                try { JSONObject object=new JSONObject(result);
                     jsonArray = object.getJSONArray("body");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);

                       // double lat = (double) obj.get("Latitude");
                      //  double longt =(double) obj.get("Longitude");

                        String addressval = obj.getString("Address");
                        String nameval = obj.getString("Name");
                        //convert cinema location to latitude longitude
                        Geocoder geoloc = new Geocoder(getActivity(), Locale.ENGLISH);

                        List<Address> addresslist = geoloc.getFromLocationName(addressval, 1);
                        if (addresslist.size() > 0) {
                            Address address = addresslist.get(0);
                            double latitude = address.getLatitude();
                            double longitude = address.getLongitude();
                            LatLng latLng = new LatLng(latitude, longitude);
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.position(latLng);
                            markerOptions.title(nameval);

                            //set markers for each organisation location in different colour
                            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                            mMap.addMarker(markerOptions).setSnippet("Address"+addressval);
                            mMap.addMarker(markerOptions).setSnippet("Distance");
                            mMap.addMarker(markerOptions).showInfoWindow();
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(9));


                        }

                    }

                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}



