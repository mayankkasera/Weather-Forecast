package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import io.reactivex.Observable

interface ForcastRepositoryI {

    fun getForecastDetails(city:String) : Observable<ForecastReponce>

}