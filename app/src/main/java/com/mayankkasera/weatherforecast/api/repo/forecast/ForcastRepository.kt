package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForcastRepository(val forcastRequests : ForcastRequests): ForcastRepositoryI {
    override fun getForecastDetails(city: String): Observable<WeatherInfoData> {
        return Observable.create<WeatherInfoData>{ emitter ->
            forcastRequests?.let{
                it.getForecastDetails(city)
                    .enqueue(object : Callback<ForecastReponce> {
                        override fun onFailure(call: Call<ForecastReponce>, t: Throwable) {
                            emitter.onError(t)
                        }
                        override fun onResponse(call: Call<ForecastReponce>, response: Response<ForecastReponce>) {
                            response.body()?.let {
                                val weatherInfoData = WeatherInfoData()
                                weatherInfoData.type = WeatherInfoData.Type.FORECAST
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