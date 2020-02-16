package com.mayankkasera.weatherforecast.ui.weather.weatherinfo

data class WeatherInfoData (
    var type: Type? = null,
    var data: Any? = null
){
    enum class Type{
        WEATHER,FORECAST
    }
}