package com.midterm.lamnhom.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.midterm.lamnhom.model.CovidVN;
import com.midterm.lamnhom.model.CovidWorld;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-HH-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://corona.lmao.ninja/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    ApiService apiServiceWorld = new Retrofit.Builder()
            .baseUrl("https://disease.sh/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("v2/countries/vn")
    Call<CovidVN> getApiCovidVN();

    @GET("v3/covid-19/all")
    Call<CovidWorld> getApiCovidWorld();

}
