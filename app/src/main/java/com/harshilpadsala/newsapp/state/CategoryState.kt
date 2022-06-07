package com.harshilpadsala.newsapp.state

sealed class CategoryState{
    object CATEGORY_SCIENCE : CategoryState()
    object CATEGORY_BUSINESS : CategoryState()
    object CATEGORY_ENTERTAINTMENT : CategoryState()
    object CATEGORY_GENERAL : CategoryState()
    object CATEGORY_SPORTS : CategoryState()
    object CATEGORY_TECHNOLOGY : CategoryState()
}
