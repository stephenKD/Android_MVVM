package com.example.mvvm.koin

import com.example.mvvm.BuildConfig
import com.example.mvvm.service.MarketService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val serviceModule = module {

    single { createOkHttpClient() }

    single<MarketService> {
        createService(get())
    }



}

object Properties {
    const val SERVER_URL = "https://api.cobinhood.com/"
}

fun createOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    val logLevelForDebug = HttpLoggingInterceptor.Level.BASIC
    return httpClient.connectTimeout(5L, TimeUnit.SECONDS)
        .readTimeout(5L, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG)
                    logLevelForDebug
                else
                    HttpLoggingInterceptor.Level.NONE
            )
        ).build()
}


inline fun <reified T> createService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(Properties.SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}

