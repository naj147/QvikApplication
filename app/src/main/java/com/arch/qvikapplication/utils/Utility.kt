package com.arch.qvikapplication.utils

import android.content.Context
import android.graphics.drawable.Drawable
import com.arch.qvikapplication.R


class Utility {
    companion object {
        fun getChannelImage(position: Int, context: Context): Drawable? {
            return when (position) {
                1 -> context.getDrawable(R.drawable.thumbnail_channel_fashion)
                2 -> context.getDrawable(R.drawable.thumbnail_channel_science)
                3 -> context.getDrawable(R.drawable.thumbnail_channel_auto)
                4 -> context.getDrawable(R.drawable.thumbnail_channel_technology)
                5 -> context.getDrawable(R.drawable.thumbnail_channel_entertainment)
                6 -> context.getDrawable(R.drawable.thumbnail_channel_environment)
                7 -> context.getDrawable(R.drawable.thumbnail_channel_finance)
                8 -> context.getDrawable(R.drawable.thumbnail_channel_travel)
                else -> context.getDrawable(R.drawable.thumbnail_channel_fashion)
            }
        }
    }
}