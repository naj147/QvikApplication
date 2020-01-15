package com.arch.qvikapplication.injection.module

import com.arch.base.dependencyInjection.qualifiers.ActivityScope
import com.arch.base.presentation.BaseActivity
import com.arch.qvikapplication.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindBaseActivity(): BaseActivity

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

}
