package com.arch.qvikapplication.presentation.channel

import android.view.LayoutInflater
import android.view.View
import com.arch.base.presentation.BaseFragment
import com.arch.qvikapplication.R
import com.arch.qvikapplication.adapter.channel.ChannelViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.layout_channel_list_fragment.*
import kotlinx.android.synthetic.main.layout_custom_tab.view.*


class ChannelListFragment : BaseFragment() {
    private lateinit var channelViewPagerAdapter: ChannelViewPagerAdapter
    override fun layoutRes(): Int {
        return R.layout.layout_channel_list_fragment
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        channelViewPagerAdapter = ChannelViewPagerAdapter(childFragmentManager)
        channelFragmentViewPager.adapter = channelViewPagerAdapter

        channelCategoryTabLayout.setupWithViewPager(channelFragmentViewPager, true)
        addTabs()
        channelFragmentViewPager.setCurrentItem(0, false)
        setTabView(channelCategoryTabLayout.getTabAt(0), true)
    }


    private fun addTabs() {
        for (i in 0 until channelCategoryTabLayout.tabCount) {
            val tab: TabLayout.Tab = channelCategoryTabLayout.getTabAt(i)!!
            tab.customView = getTabView(i)
        }

        channelCategoryTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                setTabView(tab, false)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                setTabView(tab, true)
            }

        })
    }

    private fun setTabView(tab: TabLayout.Tab?, shouldShowBackground: Boolean) {
        val view = tab?.customView
        if (shouldShowBackground) {
            view?.tabImageView?.visibility = View.VISIBLE
        } else {
            view?.tabImageView?.visibility = View.GONE
        }
    }

    private fun getTabView(position: Int): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_custom_tab, null)
        view.tabTextView.text = when (position) {
            0 -> getString(R.string.following)
            1 -> getString(R.string.popular)
            2 -> getString(R.string.explore)
            else -> getString(R.string.following)
        }

        return view
    }
}