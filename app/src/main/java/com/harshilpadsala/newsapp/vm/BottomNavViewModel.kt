package com.harshilpadsala.newsapp.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.chip.Chip
import com.harshilpadsala.newsapp.flows.SubmissionType
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BottomNavViewModel : ViewModel() {

    private val _sharedFlowOfNews = MutableSharedFlow<SubmissionType>()
    val sharedFlowOfNews = _sharedFlowOfNews.asSharedFlow()

    init {
        startCollectingChipData()
    }


    private fun startCollectingChipData(){
        viewModelScope.launch {
            _sharedFlowOfNews.collect {
                Log.i("EmissionDebug" , "In here collection is working really wel")
            }
        }
    }
}