package com.mayankkasera.weatherforecast.api

import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRepositoryI
import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRequests
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRepositoryI
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRequests
import com.mayankkasera.weatherforecast.utils.App
import javax.inject.Inject

class RepositoryHelper {

    init {
        App.networkComponent()?.inject(this)
    }

    @Inject
    lateinit var weatherRepositoryI: WeatherRepositoryI

    @Inject
    lateinit var forcastRepositoryI: ForcastRepositoryI

}