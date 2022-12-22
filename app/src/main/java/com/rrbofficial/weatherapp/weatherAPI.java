package com.rrbofficial.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weatherAPI {
    @GET ("weather?appid=36ae13924525770df437914541fc1788&units=metric")
    Call<OpenWeatherMap>getWeatherWithLocation(@Query("lat" )double lat, @Query("lon")double lon);

    @GET ("weather?appid=36ae13924525770df437914541fc1788&units=metric")
    Call<OpenWeatherMap>getWeatherWithCityName(@Query("q" )String name);
}
