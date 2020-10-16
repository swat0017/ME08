package com.example.me08;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.me08.DataVisualisation.Charts;
import com.example.me08.networkconnection.APIGatewayConnection;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class In_Org_Fragment extends Fragment {

    String compword = "[]";
    String id = null;
    int sum = 0;

    ArrayList<String> organzation = new ArrayList<String>();

    APIGatewayConnection networkConnection = null;
    private TextView address;
    private TextView phone;
    private TextView website;
    private TextView name;
    private TextView state;
    private ImageView image;
    private ImageView call_image;
    private ImageView back;
    Button mapbutton;
    String phonen="123";
    int phoneval;

    Context context;
    public In_Org_Fragment() {
    }

    private static final int REQUEST_CALL = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.in_org_layout, container, false);
        SharedPreferences sharedPref = getActivity().
                getSharedPreferences("Message", Context.MODE_PRIVATE);

        String addressval = sharedPref.getString("Address", null);
         phoneval = sharedPref.getInt("PhoneNumber", 0);
        String websiteval = sharedPref.getString("Website", null);
        String nameval = sharedPref.getString("Name", null);
        String stateval=sharedPref.getString("State", null);
        String image_path=sharedPref.getString("Image", null);

        name = view.findViewById(R.id.org_name);
        address = view.findViewById(R.id.tv_address_detail);
        phone = view.findViewById(R.id.tv_phone_detail);
        website = view.findViewById(R.id.tv_website_detail);
        state = view.findViewById(R.id.tv_state_detail);
        image = view.findViewById(R.id.image_org);
        call_image=view.findViewById(R.id.image_phone);
        call_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
        mapbutton=(Button) view.findViewById(R.id.buttonmap);
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //convert address to latitude longitude
                String addressval = address.getText().toString() + "," + state;
                Geocoder geoloc = new Geocoder(getActivity(), Locale.ENGLISH);

                List<Address> addresslist = null;
                try {
                    addresslist = geoloc.getFromLocationName(addressval, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (addresslist.size() > 0) {
                    Address address = addresslist.get(0);
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CALL);
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+latitude+ ","+longitude+"&mode=d"));
                        intent.setPackage("com.google.android.apps.maps");
                        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intent);
                    }

                }}
            }
        });

        address.setText(addressval);
        state.setText(stateval);
        phone.setText(String.valueOf(phoneval));
        website.setMovementMethod(LinkMovementMethod.getInstance());
        website.setText(websiteval);
        website.setLinksClickable(true);
        website.setLinkTextColor(Color.BLUE);
        name.setText(nameval);

        //String image_path="https://image.tmdb.org/t/p/w92/qJ2tW6WMUDux911r6m7haRef0WH.jpg";

        ImageView imageView = (ImageView) view.findViewById(R.id.image_org);
        Picasso.with(context).setLoggingEnabled(true);
      Picasso.with(context).load(image_path).resize(92,92).into(imageView);
        back =view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.me08.OrganisationviewFragment welcomeFragment=new com.example.me08.OrganisationviewFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new com.example.me08.OrganisationviewFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }


    private void makePhoneCall() {
        if (phonen.length() > 0) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            } else {
String dial="tel:"+String.valueOf(phoneval);
startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {

        }
    }
}
