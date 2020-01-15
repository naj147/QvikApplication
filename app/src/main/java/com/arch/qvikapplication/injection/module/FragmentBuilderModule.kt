package com.arch.qvikapplication.injection.module

import com.arch.base.dependencyInjection.qualifiers.FragmentScope
import com.arch.qvikapplication.presentation.SplashFragment
import com.arch.qvikapplication.presentation.articles.ArticleDetailFragment
import com.arch.qvikapplication.presentation.articles.ArticleListFragment
import com.arch.qvikapplication.presentation.channel.ChannelListFragment
import com.arch.qvikapplication.presentation.viewPager.ChannelViewPagerFragment
import com.arch.qvikapplication.presentation.viewPager.PopularFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindChannelListFragment(): ChannelListFragment

    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindChannelViewPagerFragment(): ChannelViewPagerFragment

    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindArticleListFragment(): ArticleListFragment

    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindPopularFragment(): PopularFragment

    @ContributesAndroidInjector
    @FragmentScope
    internal abstract fun bindArticleDetailFragment(): ArticleDetailFragment

}
