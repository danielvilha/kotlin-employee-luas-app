package com.danielvilha.luasapp.di.component

import android.app.Application
import com.danielvilha.luasapp.AppApplication
import com.danielvilha.luasapp.data.remote.MiddlewareApi
import com.danielvilha.luasapp.data.repository.MiddlewareRepository
import com.danielvilha.luasapp.di.module.ApplicationModule
import com.danielvilha.luasapp.utils.SchedulerProvider
import com.danielvilha.luasapp.utils.network.InternetHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: AppApplication)
    fun getApplication(): Application
    fun getSchedulerProvider(): SchedulerProvider
    fun getCompositeDisposable(): CompositeDisposable
    fun getNetworkingService(): MiddlewareApi
    fun getNetworkHelper(): InternetHelper
    fun getWebRepository(): MiddlewareRepository
}