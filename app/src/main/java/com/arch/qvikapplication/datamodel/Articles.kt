package com.arch.qvikapplication.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "channelArticle")
data class Articles(
    @PrimaryKey @SerializedName("id") val id: Int,
    @SerializedName("channelId") val channelId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("broadcaster") val broadcaster: String,
    @SerializedName("publishedAt") val publishedAt: String,
    @SerializedName("content") val content: String
) {
    override fun toString(): String {
        return "Article Info channelId = $channelId, title=$title, broadcaster=$broadcaster, date=$publishedAt "
    }
}
