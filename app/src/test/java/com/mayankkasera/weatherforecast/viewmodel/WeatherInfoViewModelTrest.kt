package com.mayankkasera.weatherforecast.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRepositoryI
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRepositoryI
import com.mayankkasera.weatherforecast.pojo.ForecastReponce
import com.mayankkasera.weatherforecast.pojo.WeatherResponse
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoData
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoState
import com.mayankkasera.weatherforecast.ui.weather.weatherinfo.WeatherInfoViewModel
import com.mayankkasera.weatherforecast.utils.ImmediateSchedulersRule
import io.reactivex.Observable
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class WeatherInfoViewModelTrest {

    @get:Rule
    val immediateSchedulersRule = ImmediateSchedulersRule()

    @get:Rule
    var rule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var weatherRepositoryI: WeatherRepositoryI

    @Mock
    lateinit var forcastRepositoryI: ForcastRepositoryI

    @Mock
    lateinit var observer: Observer<WeatherInfoState>

    var weatherInfoViewModel: WeatherInfoViewModel? = null


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        weatherInfoViewModel = WeatherInfoViewModel(weatherRepositoryI, forcastRepositoryI)
        weatherInfoViewModel?.mutableLiveData?.observeForever(observer)
    }

    @Test
    fun testNull() {
        Assert.assertNotNull(weatherInfoViewModel?.mutableLiveData)
        Assert.assertTrue(weatherInfoViewModel?.mutableLiveData!!.hasObservers())
    }

    @Test
    fun loadData_APISuccess() {

        //Arrange
        Mockito.`when`(weatherRepositoryI.getWeatherDetails("bhopal"))
            .thenReturn(
                Observable.just(
                    WeatherInfoData(
                        type = WeatherInfoData.Type.WEATHER
                        , data = WeatherResponse(base = "test")
                    )
                )
            )

        Mockito.`when`(forcastRepositoryI.getForecastDetails("bhopal"))
            .thenReturn(
                Observable.just(
                    WeatherInfoData(
                        type = WeatherInfoData.Type.FORECAST,
                        data = ForecastReponce(cod = "test")
                    )
                )
            )

        //Act
        weatherInfoViewModel?.loadData("bhopal")

        //Assert

        //loading
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true
            )
        )

        //onNext
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true,
                success = false,
                forecastReponce = ForecastReponce(cod = "test"),
                weatherResponse = WeatherResponse(base = "test")
            )
        )

        //onNext
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true,
                success = false,
                forecastReponce = ForecastReponce(cod = "test"),
                weatherResponse = WeatherResponse(base = "test")
            )
        )

        //onComplete
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = false,
                success = true,
                forecastReponce = ForecastReponce(cod = "test"),
                weatherResponse = WeatherResponse(base = "test")
            )
        )

    }

    @Test
    fun loadData_WeatherApiError() {

        //Arrange
        Mockito.`when`(weatherRepositoryI.getWeatherDetails("bhopal"))
            .thenReturn(Observable.error(Exception("Some Weather API Error Came.")))

        Mockito.`when`(forcastRepositoryI.getForecastDetails("bhopal"))
            .thenReturn(
                Observable.just(
                    WeatherInfoData(
                        type = WeatherInfoData.Type.FORECAST,
                        data = ForecastReponce(cod = "test")
                    )
                )
            )

        //Act
        weatherInfoViewModel?.loadData("bhopal")

        //Assert
        //loading
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true
            )
        )

        //onError
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = false,
                failure = true,
                message = "Some Weather API Error Came."
            )
        )

    }

    @Test
    fun loadData_ForcastApiError() {

        //Arrange
        Mockito.`when`(weatherRepositoryI.getWeatherDetails("bhopal"))
            .thenReturn(
                Observable.just(
                    WeatherInfoData(
                        type = WeatherInfoData.Type.WEATHER
                        , data = WeatherResponse(base = "test")
                    )
                )
            )

        Mockito.`when`(forcastRepositoryI.getForecastDetails("bhopal"))
            .thenReturn(Observable.error(Exception("Some Forcast API Error Came.")))

        //Act
        weatherInfoViewModel?.loadData("bhopal")

        //Assert
        //loading
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true
            )
        )

        //onNext
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = true,
                success = false,
                weatherResponse = WeatherResponse(base = "test")
            )
        )

        //onComplete
        Mockito.verify(observer).onChanged(
            WeatherInfoState(
                loading = false,
                failure = true,
                success = false,
                message = "Some Forcast API Error Came.",
                weatherResponse = WeatherResponse(base = "test")
            )
        )

    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
        weatherInfoViewModel = null
    }

}