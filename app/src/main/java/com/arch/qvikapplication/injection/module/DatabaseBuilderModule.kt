package com.arch.qvikapplication.injection.module

import android.app.Application
import com.arch.qvikapplication.database.AppDatabase
import com.arch.qvikapplication.database.ArticlesDao
import com.arch.qvikapplication.database.ChannelDao
import com.arch.qvikapplication.repository.ArticleListRepository
import com.arch.qvikapplication.repository.ChannelListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseBuilderModule {
    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideChannelDao(db: AppDatabase) = db.channelDao()

    @Singleton
    @Provides
    fun provideArticlesDao(db: AppDatabase) = db.articleDao()

    @Singleton
    @Provides
    fun provideChannelListRepository(dao: ChannelDao) = ChannelListRepository(dao)

    @Singleton
    @Provides
    fun provideArticleListRepository(dao: ArticlesDao, channelDao: ChannelDao) =
        ArticleListRepository(dao, channelDao)

}