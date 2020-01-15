package com.arch.qvikapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arch.qvikapplication.datamodel.Channel
import io.reactivex.Flowable

@Dao
interface ChannelDao {
    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(channel: List<Channel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(Channel: Channel)

    //fetch All
    @Query("SELECT * FROM channel")
    fun getAllChannels(): Flowable<List<Channel>>

    @Query("SELECT * FROM channel WHERE id = :channelId")
    fun getChannelInfo(channelId: Int): Flowable<Channel>
}
