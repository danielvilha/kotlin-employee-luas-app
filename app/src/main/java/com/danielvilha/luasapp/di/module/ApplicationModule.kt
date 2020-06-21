package com.danielvilha.luasapp.di.module

import android.app.Application
import com.danielvilha.luasapp.AppApplication
import com.danielvilha.luasapp.data.remote.MiddlewareApi
import com.danielvilha.luasapp.data.remote.Building
import com.danielvilha.luasapp.utils.SchedulerProvider
import com.danielvilha.luasapp.utils.network.InternetHelper
import com.danielvilha.luasapp.utils.rx.RxSchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Module
class ApplicationModule(private val application: AppApplication) {
    // I had to update to HTTPS because HTTP was giving an error.
    val BASE_URL = "https://luasforecasts.rpa.ie/"

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkingService(): MiddlewareApi =
        Building.create(
            BASE_URL
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): InternetHelper = InternetHelper(application)
}