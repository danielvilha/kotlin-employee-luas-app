package com.danielvilha.luasapp.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by danielvilha on 21/06/20
 */
object Building {

    private const val TIMEOUT = 60

    private val client = OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.NONE
                })
        .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        .build()

    private val converter = TikXmlConverterFactory.create(
        TikXml.Builder()
            .exceptionOnUnreadXml(false)
            .build()
        )

    fun create(baseUrl: String): MiddlewareApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(converter)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MiddlewareApi::class.java)
    }
}