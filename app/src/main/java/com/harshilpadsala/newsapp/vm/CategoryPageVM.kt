package com.harshilpadsala.newsapp.vm

import androidx.lifecycle.ViewModel

class CategoryPageVM : ViewModel() {

    data class CategoryEmission(
        val category: String,
    )
}