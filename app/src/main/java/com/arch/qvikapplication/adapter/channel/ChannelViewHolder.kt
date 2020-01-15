package com.arch.qvikapplication.adapter.channel

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.interfaces.OnChannelClickListener
import com.arch.qvikapplication.utils.Utility
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_grid_layout.*

class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View?
        get() = itemView

    fun bind(item: Channel, context: Context, onChannelClickListener: OnChannelClickListener) {
        channelName.text = item.name
        Glide.with(context).load(getChannelImage(item, context))
            .into(channelImage)

        itemView.setOnClickListener {
            onChannelClickListener.onChannelClick(item)
        }
    }

    private fun getChannelImage(item: Channel, context: Context): Drawable? {
        return Utility.getChannelImage(item.id, context)
    }
}