package com.danielvilha.luasapp

import android.app.Application
import com.danielvilha.luasapp.di.component.ApplicationComponent
import com.danielvilha.luasapp.di.component.DaggerApplicationComponent
import com.danielvilha.luasapp.di.module.ApplicationModule

/**
 * Created by danielvilha on 21/06/20
 */
class AppApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)
    }
}