package com.danielvilha.luasapp.utils.rx

import com.danielvilha.luasapp.utils.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
class RxSchedulerProvider : SchedulerProvider {
    override fun computation(): Scheduler = Schedulers.computation()
    override fun io(): Scheduler = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}