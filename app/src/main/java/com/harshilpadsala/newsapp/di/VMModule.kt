package com.harshilpadsala.newsapp.di

import com.harshilpadsala.newsapp.vm.HomeViewModel
import com.harshilpadsala.newsapp.vm.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel{MainActivityViewModel()}
    viewModel { HomeViewModel() }
}