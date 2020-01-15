package com.arch.qvikapplication.injection.module

import androidx.lifecycle.ViewModel
import com.arch.base.dependencyInjection.utils.ViewModelKey
import com.arch.qvikapplication.presentation.articles.ArticleListViewModel
import com.arch.qvikapplication.presentation.channel.ChannelListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ArticleListViewModel::class)
    internal abstract fun bindArticleListViewModel(articleListViewModel: ArticleListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChannelListViewModel::class)
    internal abstract fun bindChannelListViewModel(channelListViewModel: ChannelListViewModel): ViewModel

}
