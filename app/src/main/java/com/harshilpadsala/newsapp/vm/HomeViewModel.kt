package com.harshilpadsala.newsapp.vm

import androidx.lifecycle.viewModelScope
import com.harshilpadsala.newsapp.base.BaseViewModel
import com.harshilpadsala.newsapp.data.remote.NewsService
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel : BaseViewModel() {

    private val newsService: NewsService by inject()

    init {
        viewModelScope.launch {

        }

    }
}