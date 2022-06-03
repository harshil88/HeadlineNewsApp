package com.harshilpadsala.newsapp.ui

import android.os.Bundle
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.base.BaseActivity
import com.harshilpadsala.newsapp.databinding.ActivityMainBinding
import com.harshilpadsala.newsapp.vm.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(R.layout.activity_main) {

    override val viewmodel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

    }
}