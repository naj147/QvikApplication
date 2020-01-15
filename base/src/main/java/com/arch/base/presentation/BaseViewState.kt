package com.arch.base.presentation

open class BaseViewState<T>{
    var data : T? = null
    var error: Throwable? = null
    var currentState: Int = 0

    enum class State constructor(var value: Int) {
        FAILED(-1),
        PROGRESS(0),
        SUCCESS(1),
    }
}