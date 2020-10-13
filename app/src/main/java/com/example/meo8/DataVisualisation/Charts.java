package com.example.me08.DataVisualisation;

import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Charts {


    public static void loadintoBarchart(String json, BarChart mBarChart) throws JSONException {


        JSONObject object=new JSONObject(json.toString());
        JSONArray jsonArray = object.getJSONArray("body");

        ArrayList<BarEntry> barentries = new ArrayList<>();
 final String[] CATEGORY={"Frog","Mammal","Bird","Reptile","Insect","Spider","Fish",""};
int counter=0;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
             int intcategory=getSpecies(obj.getString("animalCategory"));
            counter++;
            int countbar = Integer.parseInt(obj.optString("count"));
            barentries.add(new BarEntry( intcategory, countbar));
        }
        BarDataSet bardataset = new BarDataSet(barentries, "Category Risk");
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData bardata = new BarData(bardataset);
        bardata.setBarWidth(0.9f);
        mBarChart.setVisibility(View.VISIBLE);
        mBarChart.animateY(3000);
        mBarChart.setData(bardata);
        XAxis xaxis = mBarChart.getXAxis();
        xaxis.setPosition(XAxis.XAxisPosition.TOP);

        xaxis.setDrawGridLines(false);
        xaxis.setGranularity(1f);
       xaxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return CATEGORY[(int) value];
            }
        });
      mBarChart.setFitBars(true);
        YAxis yAxis = mBarChart.getAxisLeft();
        yAxis.setLabelCount(counter, false);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setSpaceTop(15f);

        yAxis.setAxisMinimum(0f);
        Description descr = new Description();
        descr.setPosition(-30, -10);
        descr.setText("Category Risk of mammals");
        mBarChart.setDescription(descr);

        mBarChart.invalidate();


    }
    public static void loadintopiechart(String json, PieChart mPieChart) throws JSONException {
        final List<String> animalCategorys=new ArrayList<String>();
        ArrayList<String> months=new ArrayList<String>();
        List<Integer> count=new ArrayList<Integer>();
        List<Integer> totalcount=new ArrayList<Integer>();
        int sum=0;
        JSONObject object=new JSONObject(json.toString());
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
        desc.setText("Category Risk post Bushfire");
        desc.setTextSize(7);

        mPieChart.setDescription(desc);
        mPieChart.invalidate();
}
    public static void loadintobarchart (String json, BarChart mBarChart) throws JSONException{
        final List<String> animalSpecies = new ArrayList<String>();
        JSONObject object=new JSONObject(json.toString());
        JSONArray jsonArray = object.getJSONArray("body");

        ArrayList<BarEntry> barentries1 = new ArrayList<>();
        ArrayList<BarEntry> barentries2 = new ArrayList<>();
        int counter=0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String animalSpecie = obj.getString("animalSpecies");
            int intcategory=getSpecies(obj.getString("animalSpecies"));
            animalSpecies.add(animalSpecie);
            counter++;
            float pre = Float.parseFloat(obj.optString("PrefireMortalityRate"));
            float post = Float.parseFloat(obj.optString("PostfireMortalityRate"));
            barentries1.add(new BarEntry((float) intcategory, pre));
            barentries2.add(new BarEntry((float) intcategory, post));
        }

        BarDataSet bardataset1 = new BarDataSet(barentries1,"");
        BarDataSet bardataset2 = new BarDataSet(barentries2,"");
        bardataset1.setColors(Color.YELLOW);
        bardataset2.setColors(Color.RED);
        BarData bardata1 = new BarData(bardataset1);
        BarData bardata2 = new BarData(bardataset2);
        bardata1.setBarWidth(0.9f);
        bardata2.setBarWidth(0.9f);
        mBarChart.setVisibility(View.VISIBLE);
        mBarChart.animateY(3000);
        mBarChart.setData(bardata1);
        mBarChart.setVisibility(View.VISIBLE);
        mBarChart.animateY(3000);
        mBarChart.setData(bardata2);

        XAxis xaxis = mBarChart.getXAxis();
        xaxis.setPosition(XAxis.XAxisPosition.TOP);
        xaxis.setDrawLabels(true);
        xaxis.setGranularity(6f);
        xaxis.setAxisMaximum(18f);
        xaxis.setAxisMinimum(0f);
        xaxis.setSpaceMax(2f);

        mBarChart.setFitBars(true);
        YAxis yAxis = mBarChart.getAxisLeft();
        yAxis.setLabelCount(counter, false);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setDrawGridLines(false);
      /*  yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return animalSpecies.get((int) value);
            }
        });
*/
        Description descr = new Description();
        descr.setPosition(30, 10);
        descr.setText("Pre & Post fire mortality score");
        mBarChart.setDescription(descr);

        mBarChart.invalidate();
    }

    //method to convert category value to int
    private static int getSpecies(String month) {

        if (month.equalsIgnoreCase("Frog"))
            return 0;
        else if (month.equalsIgnoreCase("Mammal"))
            return 1;
        else if (month.equalsIgnoreCase("Bird"))
            return 2;
        else if (month.equalsIgnoreCase("Reptile"))
            return 3;
        else if (month.equalsIgnoreCase("Insect"))
            return 4;
        else if (month.equalsIgnoreCase("Spider"))
            return 5;
        else if (month.equalsIgnoreCase("Fish"))
            return 6;

        else return 7;

    }

    //method to convert category value to int
    private static int getCategory(String month) {

        if (month.equalsIgnoreCase("Vulnerable"))
            return 1;
        else if (month.equalsIgnoreCase("Critically Endangered"))
            return 2;
        else if (month.equalsIgnoreCase("Endangered"))
            return 3;
        else if (month.equalsIgnoreCase("Listed Migratory Only"))
            return 4;

        else return 0;

    }
}

