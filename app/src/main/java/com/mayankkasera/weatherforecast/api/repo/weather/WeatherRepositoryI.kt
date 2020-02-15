package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.Weather
import io.reactivex.Observable
import retrofit2.http.Query

interface WeatherRepositoryI {

    fun getWeatherDetails(city:String) : Observable<Weather>

}