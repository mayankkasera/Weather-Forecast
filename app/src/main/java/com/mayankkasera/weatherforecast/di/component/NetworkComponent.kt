package com.mayankkasera.weatherforecast.di.component

import android.content.Context
import com.mayankkasera.weatherforecast.api.RepositoryHelper
import com.mayankkasera.weatherforecast.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface NetworkComponent {

    fun inject(repositoryHelper: RepositoryHelper)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("baseUrl") baseUrl : String,
                   @BindsInstance @Named("appContext") context: Context): NetworkComponent
    }

}