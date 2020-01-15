package com.arch.qvikapplication.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "channel")
data class Channel(
    @PrimaryKey @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("isFollowing") val isFollowing: Boolean,
    @SerializedName("isPopular") val isPopular: Boolean,
    @SerializedName("shouldExplore") val shouldExplore: Boolean,
    @SerializedName("followers") val followers: String
) {
    override fun toString(): String {
        return "Channel Info id = $id, name=$name, isFollowing=$isFollowing, followers=${followers} "
    }
}
