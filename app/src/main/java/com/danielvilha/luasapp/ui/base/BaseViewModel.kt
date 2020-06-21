package com.danielvilha.luasapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielvilha.luasapp.R
import com.danielvilha.luasapp.utils.SchedulerProvider
import com.danielvilha.luasapp.utils.common.Resource
import com.danielvilha.luasapp.utils.network.InternetHelper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by danielvilha on 21/06/20
 */
abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
    private val internetHelper: InternetHelper
) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    protected fun internetConnectionWithMessage(): Boolean =
        if (internetHelper.isInternetAvailable()) {
            true
        } else {
            messageStringId.postValue(Resource.error(R.string.no_internet_error))
            false
        }

    protected fun handleNetworkError(error: Throwable?) {
        error?.let {
            messageString.postValue(Resource.error(it.message))
        }
    }

    abstract fun onCreate()
}