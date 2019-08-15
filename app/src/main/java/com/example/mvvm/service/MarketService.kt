package com.example.mvvm.service

import com.example.eddy.tkr.model.market.TickersDto
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface MarketService {
    @GET("v1/market/tickers")
    fun tickers(): Single<TickersDto>
}