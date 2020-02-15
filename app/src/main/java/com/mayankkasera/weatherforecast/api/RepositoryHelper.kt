package com.mayankkasera.weatherforecast.api

import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRequests
import javax.inject.Inject

class RepositoryHelper {

    @Inject
    lateinit var weatherRequests: WeatherRequests

}