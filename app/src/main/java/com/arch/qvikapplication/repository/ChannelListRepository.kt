package com.arch.qvikapplication.repository

import com.arch.qvikapplication.database.ChannelDao
import com.arch.qvikapplication.datamodel.Channel
import io.reactivex.Flowable
import javax.inject.Inject

class ChannelListRepository @Inject constructor(private val dao: ChannelDao) {
    fun getAllChannels(): Flowable<List<Channel>> {
        return dao.getAllChannels()
    }
}