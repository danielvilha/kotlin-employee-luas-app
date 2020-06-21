package com.danielvilha.luasapp.di.module

import androidx.lifecycle.ViewModelProviders
import com.danielvilha.luasapp.data.repository.MiddlewareRepository
import com.danielvilha.luasapp.ui.home.HomeViewModel
import com.danielvilha.luasapp.ui.base.BaseActivity
import com.danielvilha.luasapp.utils.SchedulerProvider
import com.danielvilha.luasapp.utils.ViewModelProviderFactory
import com.danielvilha.luasapp.utils.network.InternetHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by danielvilha on 21/06/20
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        internetHelper: InternetHelper,
        middlewareRepository: MiddlewareRepository
    ): HomeViewModel = ViewModelProviders.of(activity, ViewModelProviderFactory(HomeViewModel::class) {
        HomeViewModel(schedulerProvider, compositeDisposable, internetHelper, middlewareRepository)
    }).get(HomeViewModel::class.java)
}