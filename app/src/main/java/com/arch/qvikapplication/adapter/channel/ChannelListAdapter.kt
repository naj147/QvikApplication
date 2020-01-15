package com.arch.qvikapplication.adapter.channel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.qvikapplication.R
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.interfaces.OnChannelClickListener

class ChannelListAdapter(
    private val context: Context,
    private val onChannelClickListener: OnChannelClickListener
) : RecyclerView.Adapter<ChannelViewHolder>() {
    private var channelList = ArrayList<Channel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_grid_layout, parent, false)
        return ChannelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return channelList.size
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(channelList[position], context, onChannelClickListener)
    }

    fun setData(list: List<Channel>) {
        channelList.clear()
        channelList.addAll(list)
        notifyDataSetChanged()
    }
}