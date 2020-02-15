package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRequests {

    @GET("weather?")
    fun getWeatherDetails(
        @Query("q") city:String) : Call<Weather>

}