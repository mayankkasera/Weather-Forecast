package com.mayankkasera.weatherforecast.di.module

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

}