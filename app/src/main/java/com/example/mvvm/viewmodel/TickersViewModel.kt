package com.example.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eddy.tkr.model.market.TickersDto
import com.example.mvvm.dto.Resource
import com.example.mvvm.extension.addTo
import com.example.mvvm.model.TickersModel
import io.reactivex.disposables.CompositeDisposable

class TickersViewModel(private val tickersModel: TickersModel) : ViewModel() {
    private var disposable = CompositeDisposable()

    val tickers: MutableLiveData<Resource<TickersDto>> by lazy { MutableLiveData<Resource<TickersDto>>() }

    fun getTickers() {
        tickersModel.getTickers().subscribe({ dto ->
            tickers.value = Resource.success(dto)
        }, { t: Throwable? ->
            tickers.value = Resource.error(t?.message, null)
        }).addTo(disposable)


    }


    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}