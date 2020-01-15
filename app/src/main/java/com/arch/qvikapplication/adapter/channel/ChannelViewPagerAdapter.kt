package com.arch.qvikapplication.adapter.channel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.arch.qvikapplication.presentation.viewPager.ChannelViewPagerFragment
import com.arch.qvikapplication.presentation.viewPager.PopularFragment

class ChannelViewPagerAdapter internal constructor(manager: FragmentManager) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ChannelViewPagerFragment()
            else -> PopularFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
