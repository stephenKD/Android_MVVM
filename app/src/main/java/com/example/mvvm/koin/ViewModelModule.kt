package com.example.mvvm.koin

import com.example.mvvm.viewmodel.TickersViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { TickersViewModel(get()) }

}