package com.example.jack.retrofit.services;

import android.view.View;

import com.example.jack.retrofit.external_class.TLSSocketFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{


public static final String BASE_URL="https://api.myjson.com/";


    private static Retrofit retrofit = null;


    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {

            OkHttpClient client=new OkHttpClient();
            try {
                client = new OkHttpClient.Builder()
                        .sslSocketFactory(new TLSSocketFactory())
                        .build();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }



//        String LINK = "https://api.github.com";
//        Retrofit retrofit = new Retrofit.Builder ().client(client).baseUrl (LINK).build ();
//        GithubServise githubServise= retrofit.create (GithubServise.class);
//        githubServise.getGithub ().enqueue (new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    textView.setText (response.body ().string ());
//                    Log.v ("TAG","yes");
//                } catch (IOException e) {
//                    e.printStackTrace ();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                textView.setText ("no data");
//
//            }
//        });

}
