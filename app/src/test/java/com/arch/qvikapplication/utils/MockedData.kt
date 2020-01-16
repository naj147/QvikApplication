package com.arch.qvikapplication.utils

import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel

object MockedData {
    val mockedArticle = Articles(1,1,"Arctic sea","CNN","03 Jun 2015", "Sea Article")
    val mockedChannel = Channel(1,"science",true,
        isPopular = false,
        shouldExplore = false,
        followers = "12K"
    )

    val mockedArticleList = listOf(mockedArticle)
    val mockedChannelList = listOf(mockedChannel)
}