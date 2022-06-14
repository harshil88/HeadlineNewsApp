package com.harshilpadsala.newsapp.vm

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.android.material.chip.Chip
import com.harshilpadsala.newsapp.base.BaseViewModel
import com.harshilpadsala.newsapp.data.remote.NewsService
import com.harshilpadsala.newsapp.data.response.News
import com.harshilpadsala.newsapp.data.source.NewsDataStoreFlow
import com.harshilpadsala.newsapp.flows.ActionType
import com.harshilpadsala.newsapp.flows.SubmissionType
import com.harshilpadsala.newsapp.flows.topicFlows
import com.harshilpadsala.newsapp.flows.topicFlowsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.inject
import java.util.function.Predicate

class HomeViewModel : BaseViewModel() {

    private val _newsStateFlow = MutableStateFlow<List<News>>(
      listOf()
    )
    val newsFlow = _newsStateFlow.asStateFlow()


    private val newsDataSource = NewsDataStoreFlow()

    init {
        viewModelScope.launch {
            newsDataSource.latestNews.collect{
                Log.i("DiffUtil" , "Main flow collector was called")
                _newsStateFlow.value = it.articles
            }
        }
    }
}