package com.example.mvvm.extension

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Use SchedulerProvider configuration for Single
 */
fun <T> Single<T>.with(): Single<T> = observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

fun <T> Flowable<T>.with(): Flowable<T> = observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

fun Completable.with(): Completable = observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())