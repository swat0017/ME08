package com.example.me08;
//Created by:Swathy Chandran
// Date:28-08-2020

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.me08.networkconnection.APIGatewayConnection;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class HomeActivity extends AppCompatActivity {
    APIGatewayConnection networkConnection = null;
    String compword = "[]";
    String id = null;
    ListView mName;
    ListView rdate;
    ListView rat;
    TextView dateview;
    TextView textView;
    Button but1;

    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapter3;
EditText pwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        but1=(Button)findViewById(R.id.button2);
        pwd=(EditText)findViewById(R.id.password) ;
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String val=pwd.getText().toString().trim();
                if(val.equals("ME08_123")) {
                    Intent registerIntent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(registerIntent);
                }
                else

                    Toast.makeText(getApplicationContext(), "Password incorrect,Please re enter", Toast.LENGTH_LONG).show();


            }});

    }


}
