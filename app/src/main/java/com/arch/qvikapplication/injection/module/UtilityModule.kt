package com.arch.qvikapplication.injection.module

import android.content.Context
import android.content.res.AssetManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UtilityModule {
    @Provides
    @Singleton
    fun provideAssetManager(context: Context): AssetManager {
        return context.assets
    }
}
