package com.arch.qvikapplication.presentation

import android.os.Bundle
import android.os.CountDownTimer
import androidx.navigation.Navigation
import com.arch.base.presentation.BaseFragment
import com.arch.qvikapplication.R

class SplashFragment : BaseFragment() {
    override fun layoutRes(): Int {
        return R.layout.layout_splash
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDelay()
    }

    private fun injectDelay() {
        val timer = object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                view?.let {
                    Navigation.findNavController(it)
                        .navigate(R.id.action_splash_to_channelListFragment, null, null, null)
                }
            }
        }
        timer.start()
    }

}