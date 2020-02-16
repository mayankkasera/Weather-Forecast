package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoData
import io.reactivex.Observable

interface WeatherRepositoryI {

    fun getWeatherDetails(city:String) : Observable<WeatherInfoData>

}