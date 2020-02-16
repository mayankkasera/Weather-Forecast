package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(val weatherRequests: WeatherRequests) : WeatherRepositoryI {

    override fun getWeatherDetails(city:String) : Observable<WeatherInfoData>{
        return Observable.create<WeatherInfoData> { emitter ->
            weatherRequests?.let {
               it.getWeatherDetails(city).enqueue(object : Callback<WeatherResponse>{
                   override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                       emitter.onError(t)
                   }
                   override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                       response.body()?.let {
                           val weatherInfoData = WeatherInfoData()
                           weatherInfoData.type = WeatherInfoData.Type.WEATHER
                           weatherInfoData.data = it
                           emitter.onNext(weatherInfoData)
                           emitter.onComplete()
                       } ?: run {
                           emitter.onNext(WeatherInfoData())
                           emitter.onComplete()
                       }
                   }
               })
            }
        }
    }
}