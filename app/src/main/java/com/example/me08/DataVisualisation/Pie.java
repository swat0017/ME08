package com.example.me08.DataVisualisation;

import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pie { public static void loadintopiechart(String json, PieChart mPieChart) throws JSONException {
    final List<String> animalCategorys = new ArrayList<String>();
    ArrayList<String> months = new ArrayList<String>();
    List<Integer> count = new ArrayList<Integer>();
    List<Integer> totalcount = new ArrayList<Integer>();
    int sum = 0;
    JSONObject object = new JSONObject(json.toString());
    JSONArray jsonArray = object.getJSONArray("body");
    List<PieEntry> entries = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject obj = jsonArray.getJSONObject(i);
        String animalCategory = obj.getString("animalCategory");
        animalCategorys.add(animalCategory);
        int val = obj.getInt("count");
        count.add(val);
        sum += val;
    }
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject obj = jsonArray.getJSONObject(i);
        entries.add(new PieEntry((count.get(i) * 100) / sum, animalCategorys.get(i)));


    }
    mPieChart.setVisibility(View.VISIBLE);

    mPieChart.animateXY(2000, 2000);
    PieDataSet piedataset = new PieDataSet(entries, "");
    piedataset.setColors(ColorTemplate.COLORFUL_COLORS);
    PieData piedata = new PieData(piedataset);
    piedata.setValueFormatter(new PercentFormatter());
    System.out.println(piedata);

//mPieChart.setExtraOffsets(5,10,5,5);
    mPieChart.setData(piedata);
    Description desc = new Description();
    desc.setText("Category Risk for animal");
    desc.setTextSize(7);

    mPieChart.setDescription(desc);
    mPieChart.invalidate();
}
}
