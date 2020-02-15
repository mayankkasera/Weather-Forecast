package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.Forecast
import com.mayankkasera.weatherforecast.pojo.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForcastRepository(val forcastRequests : ForcastRequests): ForcastRepositoryI {
    override fun getForecastDetails(city: String): Observable<Forecast> {
        return Observable.create<Forecast>{emitter ->
            forcastRequests?.let{
                it.getForecastDetails(city)
                    .enqueue(object : Callback<Forecast> {
                        override fun onFailure(call: Call<Forecast>, t: Throwable) {
                            emitter.onError(t)
                        }
                        override fun onResponse(call: Call<Forecast>, response: Response<Forecast>) {
                            response.body()?.let {
                                emitter.onNext(it)
                                emitter.onComplete()
                            } ?: run {
                                emitter.onNext(Forecast())
                                emitter.onComplete()
                            }
                        }
                    })
            }
        }
    }
}