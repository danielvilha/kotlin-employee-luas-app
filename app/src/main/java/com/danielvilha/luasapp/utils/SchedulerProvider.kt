package com.danielvilha.luasapp.utils

import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
interface SchedulerProvider {
    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler
}