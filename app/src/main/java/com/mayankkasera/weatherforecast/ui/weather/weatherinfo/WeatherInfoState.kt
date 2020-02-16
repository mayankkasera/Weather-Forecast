
package com.mayankkasera.weatherforecast.ui.weather.weatherinfo

import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import com.mayankkasera.weatherforecast.pojo.WeatherResponse

data class WeatherInfoState(
    var loading: Boolean = false,
    var success: Boolean = false,
    var failure: Boolean = false,
    var message: String = "",
    var forecastReponce: ForecastReponce = ForecastReponce(),
    var weatherResponse: WeatherResponse = WeatherResponse()
){
   companion object {
       val LOADING_STATE = WeatherInfoState(loading=true)
   }
}
