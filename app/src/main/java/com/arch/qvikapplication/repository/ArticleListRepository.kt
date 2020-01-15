package com.arch.qvikapplication.repository

import com.arch.qvikapplication.database.ArticlesDao
import com.arch.qvikapplication.database.ChannelDao
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel
import io.reactivex.Flowable
import javax.inject.Inject

class ArticleListRepository @Inject constructor(
    private val dao: ArticlesDao,
    private val channelDao: ChannelDao
) {
    fun getAllChannels(channelId: Int): Flowable<List<Articles>> {
        return dao.getAllArticleOfChannel(channelId)
    }

    fun getChannelInfo(channelId: Int): Flowable<Channel> {
        return channelDao.getChannelInfo(channelId)
    }

    fun getArticleInfo(articleId: Int): Flowable<Articles> {
        return dao.getArticleDetail(articleId)
    }
}