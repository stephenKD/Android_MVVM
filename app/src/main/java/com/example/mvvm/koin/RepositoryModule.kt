package com.example.mvvm.koin

import com.example.mvvm.model.TickersModel
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { TickersModel(get()) }
}