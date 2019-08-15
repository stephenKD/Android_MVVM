package com.example.mvvm.model

import com.example.eddy.tkr.model.market.TickersDto
import com.example.mvvm.extension.with
import com.example.mvvm.service.MarketService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TickersModel(private val marketService: MarketService) {
    fun getTickers(): Single<TickersDto> =
        marketService.tickers().with()

}