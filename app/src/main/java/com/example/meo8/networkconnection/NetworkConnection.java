package com.example.me08.networkconnection;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//Class to handle connection with server side api calls
public class NetworkConnection {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private OkHttpClient client=null;

    private String results;
    private static final AtomicInteger countcredential = new AtomicInteger(107);
    private static final AtomicInteger countMemoir = new AtomicInteger(2060);
    public static final MediaType JSON =
            MediaType.parse("application/json; charset=utf-8");
    public NetworkConnection(){
        client=new OkHttpClient();
    }
    private static final String BASE_URL =
            "http://192.168.1.178:8080/FIT5046ASSIGN1/webresources/";



//get method
    public String getAnimalsByCategory(String id, String year) {
        final String methodPath = "entity.memoir/findTotalMoviesperyear/"+id+"/"+year;
        System.out.println(methodPath);
        Request.Builder builder = new Request.Builder();
        builder.url(BASE_URL + methodPath);
        Request request = builder.build();
        try {
            Response response = client.newCall(request).execute();
            results = response.body().string();

            System.out.println(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
