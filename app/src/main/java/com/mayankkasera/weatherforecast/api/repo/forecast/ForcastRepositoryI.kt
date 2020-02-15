package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.Forecast
import com.mayankkasera.weatherforecast.pojo.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForcastRepositoryI {

    fun getForecastDetails(city:String) : Observable<Forecast>

}