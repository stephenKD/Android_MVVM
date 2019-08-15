package com.example.mvvm

import androidx.multidex.MultiDexApplication
import com.example.mvvm.koin.repositoryModule
import com.example.mvvm.koin.serviceModule
import com.example.mvvm.koin.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(serviceModule, repositoryModule, viewModelModule))
    }
}