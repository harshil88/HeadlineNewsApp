package com.harshilpadsala.newsapp.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.base.BaseActivity
import com.harshilpadsala.newsapp.databinding.ActivityMainBinding
import com.harshilpadsala.newsapp.vm.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(R.layout.activity_main) {
    override val viewmodel: MainActivityViewModel by viewModel()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         supportActionBar!!.hide()
         val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         val navController = navHostFragment!!.navController
         NavigationUI.setupWithNavController(findViewById<BottomNavigationView>(R.id.bottomNavigationView), navController)
    }
}