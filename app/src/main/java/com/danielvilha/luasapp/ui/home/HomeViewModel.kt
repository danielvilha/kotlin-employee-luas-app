package com.danielvilha.luasapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.danielvilha.luasapp.data.model.Direction
import com.danielvilha.luasapp.data.repository.MiddlewareRepository
import com.danielvilha.luasapp.ui.base.BaseViewModel
import com.danielvilha.luasapp.utils.SchedulerProvider
import com.danielvilha.luasapp.utils.common.Resource
import com.danielvilha.luasapp.utils.common.Time
import com.danielvilha.luasapp.utils.network.InternetHelper
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    internetHelper: InternetHelper,
    private val middlewareRepository: MiddlewareRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, internetHelper) {

    companion object {
        const val INBOUND = "Inbound"
        const val OUTBOUND = "Outbound"
        const val MAR = "Marlborough"
        const val STI = "Stillorgan"
    }

    private val forecasts: MutableLiveData<Resource<Direction>> = MutableLiveData()
    private val destinations: MutableLiveData<String> = MutableLiveData()
    private val directions: MutableLiveData<String> = MutableLiveData()
    private val loadings: MutableLiveData<Boolean> = MutableLiveData()

    fun getForecastData(): LiveData<Direction> = Transformations.map(forecasts) {
        it.data
    }

    fun getDestination(): LiveData<String> = destinations
    fun getDirection(): LiveData<String> = directions
    fun getLoadVisibility(): LiveData<Boolean> = loadings
    fun refresh() = onCreate()

    override fun onCreate() {
        if (internetConnectionWithMessage()) {
            forecasts.postValue(Resource.loading())
            loadings.postValue(true)

            if (Time.checkCurrentTime()) {
                GlobalScope.launch {
                    compositeDisposable.add(
                        middlewareRepository.doMarlboroughCall("forecast", "mar", false)
                            .subscribeOn(schedulerProvider.io())
                            .subscribe(
                                {
                                    val name = it[1].name
                                    if (name == OUTBOUND) {
                                        forecasts.postValue(Resource.success(it[1]))
                                        directions.postValue(OUTBOUND)
                                        destinations.postValue(MAR)
                                        loadings.postValue(false)
                                    }
                                },
                                {
                                    handleNetworkError(it)
                                    forecasts.postValue(Resource.error())
                                    loadings.postValue(false)
                                }
                            )
                    )
                }
            } else {
                GlobalScope.launch {
                    compositeDisposable.add(
                        middlewareRepository.doStillorganCall("forecast", "sti", false)
                            .subscribeOn(schedulerProvider.io())
                            .subscribe(
                                {
                                    val name = it[0].name
                                    if (name == INBOUND) {
                                        Log.v(HomeViewModel::class.java.name, name)
                                        forecasts.postValue(Resource.success(it[0]))
                                        directions.postValue(INBOUND)
                                        destinations.postValue(STI)
                                        loadings.postValue(false)
                                    }
                                },
                                {
                                    handleNetworkError(it)
                                    forecasts.postValue(Resource.error())
                                    loadings.postValue(false)
                                }
                            )
                    )
                }
            }
        }
    }
}