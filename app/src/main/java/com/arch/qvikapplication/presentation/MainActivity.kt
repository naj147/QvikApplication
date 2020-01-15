package com.arch.qvikapplication.presentation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import com.arch.base.presentation.BaseActivity
import com.arch.qvikapplication.R
import dagger.android.AndroidInjection

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController
    private lateinit var navGraph: NavGraph

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        navController = Navigation.findNavController(
            this,
            R.id.navHostFragment
        )
        navGraph = navController.navInflater.inflate(R.navigation.main_nav_graph)
        val bundle = Bundle()
        navGraph.startDestination = R.id.splashFragment

        navController.setGraph(navGraph, bundle)
    }
}