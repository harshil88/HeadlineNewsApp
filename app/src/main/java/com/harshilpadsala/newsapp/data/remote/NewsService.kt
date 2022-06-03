package com.harshilpadsala.newsapp.data.remote

import com.harshilpadsala.newsapp.constants.Endpoint
import com.harshilpadsala.newsapp.constants.Params
import com.harshilpadsala.newsapp.data.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Flow

interface NewsService {
    @GET(Endpoint.TOP_HEADLINES)
    suspend fun fetchHeadlines(
        @Query("apiKey") apiKey : String = Params.API_KEY,
        @Query("page") page: Int,
        @Query("pageSize") pageSize : Int,
        @Query("country") country: String = "in",
        @Query("category") category: String,
    ) : NewsResponse

    @GET(Endpoint.EVERYTHING)
    suspend fun searchForNews(
        @Query("apiKey") apiKey: String = Params.API_KEY,
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize : Int,
        @Query("country") country: String = "in",
        @Query("category") category: String,
    )
}