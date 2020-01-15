package com.arch.base.presentation

import android.app.Application
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    protected lateinit var application: Application

    val disposables = CompositeDisposable()

    @CallSuper
    override fun onCleared() = disposables.dispose()
}