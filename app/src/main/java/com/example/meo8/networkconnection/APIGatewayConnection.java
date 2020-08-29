//Created by:Swathy Chandran
// Date:28-08-2020
package com.example.me08.networkconnection;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//Class to handle api gateway communication
//used to query details for animal fire rsisk statistics
public class APIGatewayConnection {
    private OkHttpClient client=null;
    private String results;

    public static final MediaType JSON =
            MediaType.parse("application/json; charset=utf-8");
    public APIGatewayConnection(){
        client=new OkHttpClient();
    }
    private static final String BASE_URL =
            "https://4jv3dcocbj.execute-api.us-east-1.amazonaws.com/dev/";



    //get method for mammal
    public String getMammalsByCategory() {
        final String methodPath = "/mammal";
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

    public String getBirdsByCategory() {
        final String methodPath = "/bird";
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

    //get method for mammal
    public String getFishByCategory() {
        final String methodPath = "/fish";
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
    //get method for mammal
    public String getInsectsByCategory() {
        final String methodPath = "/mammal";
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
