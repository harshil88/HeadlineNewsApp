package com.harshilpadsala.newsapp.data.source

import com.harshilpadsala.newsapp.data.remote.NewsService
import com.harshilpadsala.newsapp.data.response.NewsResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject

class NewsDataStoreFlow : KoinComponent {

    private val service : NewsService by inject()

    private val refreshIntervalMs : Long = 5000

    val latestNews: Flow<NewsResponse> = flow {
        while (true){
            val latestNews = service.fetchHeadlines(
                page = 1,
                pageSize = 10,
                category = "science",
            )
            emit(latestNews)
            delay(refreshIntervalMs)
        }
    }

}