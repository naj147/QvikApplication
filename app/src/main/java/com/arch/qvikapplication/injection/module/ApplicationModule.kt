package com.arch.qvikapplication.injection.module

import android.app.Application
import com.arch.qvikapplication.application.BaseApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: BaseApplication): Application
}
