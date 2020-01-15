package com.arch.qvikapplication.injection.component

import com.arch.base.dependencyInjection.qualifiers.ApplicationScope
import com.arch.qvikapplication.application.BaseApplication
import com.arch.qvikapplication.injection.module.ActivityBuilderModule
import com.arch.qvikapplication.injection.module.ApplicationModule
import com.arch.qvikapplication.injection.module.ContextModule
import com.arch.qvikapplication.injection.module.DatabaseBuilderModule
import com.arch.qvikapplication.injection.module.FragmentBuilderModule
import com.arch.qvikapplication.injection.module.UtilityModule
import com.arch.qvikapplication.injection.module.ViewModelFactoryModule
import com.arch.qvikapplication.injection.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@ApplicationScope
@Singleton
@Component(
    modules = [
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ContextModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        UtilityModule::class,
        DatabaseBuilderModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    override fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): ApplicationComponent
    }
}