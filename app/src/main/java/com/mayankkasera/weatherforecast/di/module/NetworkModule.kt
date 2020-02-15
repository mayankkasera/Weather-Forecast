package com.mayankkasera.weatherforecast.di.module

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.mayankkasera.weatherforecast.di.intercepter.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(@Named("baseUrl") baseUrl :String, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttp(@Named("appContext") context: Context) : OkHttpClient{
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(AuthorizationInterceptor(context))
            .build()
    }

}