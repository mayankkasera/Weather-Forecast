package com.mayankkasera.weatherforecast.ui.weather.weatherinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRepositoryI
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRepositoryI
import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class WeatherInfoViewModel(val weatherRepositoryI: WeatherRepositoryI,
                           val forcastRepositoryI: ForcastRepositoryI) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    var mutableLiveData: MutableLiveData<WeatherInfoState> = MutableLiveData()
    private var state = WeatherInfoState()
        set(value)  {
            field = value
            publishState(value)
        }

    fun loadData(city : String){
        state = state.copy(loading = true)

        compositeDisposable.add(
            Observable.merge(
                Arrays.asList(
                    weatherRepositoryI.getWeatherDetails(city),
                    forcastRepositoryI.getForecastDetails(city)
                )
            ) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                      when(it.type){
                          WeatherInfoData.Type.WEATHER -> {
                              val weatherResponse = it.data as WeatherResponse
                              state = state.copy(weatherResponse = weatherResponse)
                          }
                          WeatherInfoData.Type.FORECAST -> {
                              val forecastReponce  = it.data as ForecastReponce
                              state = state.copy(forecastReponce = forecastReponce)
                          }

                      }
                },{
                    state = state.copy(
                        loading = false,
                        failure = true,
                        message = it.localizedMessage
                    )
                }, {
                    state = state.copy(
                        loading = false,
                        success = true
                    )
                }, {

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private fun publishState(state: WeatherInfoState) {
        mutableLiveData.postValue(state)
    }

}