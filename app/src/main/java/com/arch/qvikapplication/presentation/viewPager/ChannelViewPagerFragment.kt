package com.arch.qvikapplication.presentation.viewPager

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arch.base.presentation.BaseFragment
import com.arch.base.presentation.BaseViewModelFactory
import com.arch.qvikapplication.R
import com.arch.qvikapplication.adapter.channel.ChannelListAdapter
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.interfaces.OnChannelClickListener
import com.arch.qvikapplication.presentation.channel.ChannelListViewModel
import kotlinx.android.synthetic.main.layout_channel_viewpager_fragment.*
import javax.inject.Inject

class ChannelViewPagerFragment : BaseFragment(), OnChannelClickListener {
    @Inject lateinit var viewModelFactory: BaseViewModelFactory
    private lateinit var channelListAdapter: ChannelListAdapter
    private lateinit var onChannelClickListener: OnChannelClickListener

    private val viewModel: ChannelListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ChannelListViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.layout_channel_viewpager_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

        viewModel.channelListLiveData.observe(this, Observer {
            setupRecyclerViewAdapter(it)
        })

        viewModel.responseErrorLiveData.observe(this, Observer {
            Toast.makeText(context,"Error fetching data, Try again later",Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecyclerViewAdapter(channelList: List<Channel>?) {
        channelList?.let { channelListAdapter.setData(it) }
    }

    private fun init() {
        onChannelClickListener = this
        channelListRecyclerView.layoutManager = GridLayoutManager(context, 2)
        channelListRecyclerView.isNestedScrollingEnabled = true
        channelListAdapter = ChannelListAdapter(context!!, onChannelClickListener)
        channelListRecyclerView.adapter = channelListAdapter
        ViewCompat.setNestedScrollingEnabled(channelListRecyclerView, false)
        setupRecyclerViewTouchInterceptor()
    }

    private fun setupRecyclerViewTouchInterceptor() {
        channelListRecyclerView.setOnTouchListener { v, event ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            return@setOnTouchListener false
        }
    }

    override fun onChannelClick(item: Channel) {
        val bundle = Bundle()
        bundle.putInt("channelId", item.id)
        parentFragment?.findNavController()
            ?.navigate(R.id.action_channelList_to_articleListFragment, bundle, null, null)
    }
}