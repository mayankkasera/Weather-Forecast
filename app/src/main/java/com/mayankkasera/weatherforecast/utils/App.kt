package com.mayankkasera.weatherforecast.utils

import android.app.Application
import com.facebook.stetho.Stetho
import com.mayankkasera.weatherforecast.api.NetworkConstants
import com.mayankkasera.weatherforecast.di.component.DaggerNetworkComponent
import com.mayankkasera.weatherforecast.di.component.NetworkComponent
import io.reactivex.plugins.RxJavaPlugins


class App : Application() {

    companion object {

        private var networkComponent : NetworkComponent? = null

        fun networkComponent(): NetworkComponent? {
            return networkComponent
        }

    }

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { throwable: Throwable? -> }
        Stetho.initializeWithDefaults(this)
        networkComponent = DaggerNetworkComponent.factory().create(NetworkConstants.baseUrl,this);

    }


}