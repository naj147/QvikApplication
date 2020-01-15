package com.arch.qvikapplication.application

import com.arch.qvikapplication.injection.component.DaggerApplicationComponent
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    private val applicationInjector = DaggerApplicationComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector
}