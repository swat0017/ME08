package com.example.meo8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.me08.R;

public class AboutUs extends AppCompatActivity {
    private TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        TextView textView1 = (TextView) findViewById(R.id.aboutusdetails);
        textView1.setText("The WildAid app aims to help users survive the bushfire disaster by providing users with a lot of information about the animals affected by bushfire and providing a lot of organizational information. WildAid uses pictures to reflect the current situation of seven different kinds of animals. And it can display all the organizations around users that can help these animals, so that they can seek help from these organizations or participate in volunteer activities.");
        TextView textView2 = (TextView)findViewById(R.id.aboutusnav);
        textView2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        TextView textView3 = (TextView)findViewById(R.id.aboutustitle);
        textView3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        TextView textView4 = (TextView)findViewById(R.id.aboutus);
        textView4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }
}
