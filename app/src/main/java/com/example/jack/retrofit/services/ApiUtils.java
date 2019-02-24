package com.example.jack.retrofit.services;

public class ApiUtils {

    private ApiUtils() {}


    public static final String BASE_URL = "https://api.myjson.com/";

    //public static final String BASE_URL ="https://simplifiedcoding.net/demos/";


    public static ApiInterface getAPIService() {
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
