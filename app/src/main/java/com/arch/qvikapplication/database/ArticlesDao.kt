package com.arch.qvikapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arch.qvikapplication.datamodel.Articles
import io.reactivex.Flowable

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Articles>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articles: Articles)

    @Query("SELECT * FROM channelArticle WHERE channelId = :channelId")
    fun getAllArticleOfChannel(channelId: Int): Flowable<List<Articles>>

    @Query("SELECT * FROM channelArticle WHERE id = :articleId")
    fun getArticleDetail(articleId: Int): Flowable<Articles>
}
