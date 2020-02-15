package com.mayankkasera.weatherforecast.api.repo.forecast

import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForcastRepository(val forcastRequests : ForcastRequests): ForcastRepositoryI {
    override fun getForecastDetails(city: String): Observable<ForecastReponce> {
        return Observable.create<ForecastReponce>{ emitter ->
            forcastRequests?.let{
                it.getForecastDetails(city)
                    .enqueue(object : Callback<ForecastReponce> {
                        override fun onFailure(call: Call<ForecastReponce>, t: Throwable) {
                            emitter.onError(t)
                        }
                        override fun onResponse(call: Call<ForecastReponce>, response: Response<ForecastReponce>) {
                            response.body()?.let {
                                emitter.onNext(it)
                                emitter.onComplete()
                            } ?: run {
                                emitter.onNext(ForecastReponce())
                                emitter.onComplete()
                            }
                        }
                    })
            }
        }
    }
}