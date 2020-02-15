package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForcastRequests {
    @GET("forecast?")
    fun getForecastDetails(
        @Query("q") city:String) : Call<ForecastReponce>
}