package com.example.jack.retrofit.services;

import com.example.jack.retrofit.model.Hero;
import com.example.jack.retrofit.model.RestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("bins/uv8ty")
public Call<Hero> getAllHero();


}
