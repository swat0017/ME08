package com.example.me08.networkconnection;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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



    //get category count details method for mammals
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
    //get category count details method for birds
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

    //get category count details method for fish
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
    //get category count details method for spider
    public String getSpiderByCategory() {
        final String methodPath = "/spider";
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
    //get category count details method for insects
    public String getInsectsByCategory() {
        final String methodPath = "/insect";
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
    //get category count details method for frog
    public String getFrogsByCategory() {
        final String methodPath = "/frog";
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
    //get category count details method for reptile
    public String getReptilesByCategory() {
        final String methodPath = "/reptile";
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
    //get category count details method for reptile
    public String getResult() {
        final String methodPath = "/preliminary";
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

    public String getOrganzationResult() {
        String str = "";
        return str;
    }
}
