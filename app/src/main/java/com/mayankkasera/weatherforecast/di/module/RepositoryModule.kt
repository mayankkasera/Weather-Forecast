package com.mayankkasera.weatherforecast.di.module

import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRepository
import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRepositoryI
import com.mayankkasera.weatherforecast.api.repo.forecast.ForcastRequests
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRepository
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRepositoryI
import com.mayankkasera.weatherforecast.api.repo.weather.WeatherRequests
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherRequests: WeatherRequests) : WeatherRepositoryI {
        return WeatherRepository(weatherRequests)
    }

    @Provides
    @Singleton
    fun provideForecastRepository(forcastRequests: ForcastRequests) : ForcastRepositoryI {
        return ForcastRepository(forcastRequests)
    }

}