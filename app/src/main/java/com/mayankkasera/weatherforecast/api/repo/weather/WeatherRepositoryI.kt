package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import io.reactivex.Observable

interface WeatherRepositoryI {

    fun getWeatherDetails(city:String) : Observable<WeatherResponse>

}