package com.danielvilha.luasapp.di.component

import com.danielvilha.luasapp.di.ActivityScope
import com.danielvilha.luasapp.di.module.ActivityModule
import com.danielvilha.luasapp.ui.home.HomeActivity
import dagger.Component

/**
 * Created by danielvilha on 21/06/20
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: HomeActivity)
}