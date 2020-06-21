package com.danielvilha.luasapp.data.remote

import com.danielvilha.luasapp.data.model.StopInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by danielvilha on 21/06/20
 */
@Singleton
interface MiddlewareApi {

    @GET(Config.FORECAST)
    fun getStillorganCall(
        @Query("action") action: String,
        @Query("stop") stop: String,
        @Query("encrypt") encrypt: Boolean
    ): Single<StopInfo>

    @GET(Config.FORECAST)
    fun getMarlboroughCall(
        @Query("action") action: String,
        @Query("stop") stop: String,
        @Query("encrypt") encrypt: Boolean
    ): Single<StopInfo>
}