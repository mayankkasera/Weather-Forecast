package com.mayankkasera.weatherforecast.api.repo.weather

import com.mayankkasera.weatherforecast.pojo.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(val weatherRequests: WeatherRequests) : WeatherRepositoryI {

    override fun getWeatherDetails(city:String) : Observable<Weather>{
        return Observable.create<Weather> { emitter ->
            weatherRequests?.let {
               it.getWeatherDetails(city).enqueue(object : Callback<Weather>{
                   override fun onFailure(call: Call<Weather>, t: Throwable) {
                       emitter.onError(t)
                   }
                   override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                       response.body()?.let {
                           emitter.onNext(it)
                           emitter.onComplete()
                       } ?: run {
                           emitter.onNext(Weather())
                           emitter.onComplete()
                       }
                   }
               })
            }
        }
    }
}