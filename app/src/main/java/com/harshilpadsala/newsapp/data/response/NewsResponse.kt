package com.harshilpadsala.newsapp.data.response

data class NewsResponse(
    val status : String,
    val totalResults : Int,
    val articles : List<News>
)
