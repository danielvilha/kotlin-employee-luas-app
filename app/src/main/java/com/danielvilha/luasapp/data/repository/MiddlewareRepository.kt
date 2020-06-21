package com.danielvilha.luasapp.data.repository

import com.danielvilha.luasapp.data.model.Direction
import com.danielvilha.luasapp.data.remote.MiddlewareApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
class MiddlewareRepository @Inject constructor(private val middlewareApi: MiddlewareApi) {

    fun doStillorganCall(action: String, stop: String, encrypt: Boolean): Single<List<Direction>> {
        return middlewareApi.getStillorganCall(action, stop, encrypt)
            .map {
                it.direction
            }
    }

    fun doMarlboroughCall(action: String, stop: String, encrypt: Boolean): Single<List<Direction>> {
        return middlewareApi.getMarlboroughCall(action, stop, encrypt)
            .map {
                it.direction
            }
    }
}