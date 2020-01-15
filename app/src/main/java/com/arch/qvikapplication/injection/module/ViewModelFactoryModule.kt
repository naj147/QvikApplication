package com.arch.qvikapplication.injection.module

import androidx.lifecycle.ViewModelProvider
import com.arch.base.presentation.BaseViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory
}
