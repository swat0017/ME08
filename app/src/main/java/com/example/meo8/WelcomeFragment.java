package com.example.me08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


    public class WelcomeFragment extends Fragment {

        String compword = "[]";
        String id = null;
        ListView mName;
        ListView rdate;
        ListView rat;
        TextView dateview;
        TextView textView;


        ArrayAdapter<String> arrayAdapter;
        ArrayAdapter<String> arrayAdapter2;
        ArrayAdapter<String> arrayAdapter3;

        public WelcomeFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);}
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.activity_welcome, container, false);
            return view;

        }}
