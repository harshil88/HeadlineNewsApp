package com.harshilpadsala.newsapp.flows

import com.google.android.material.chip.Chip
import com.harshilpadsala.newsapp.model.CountryData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow


enum class DataType{
    CATEGORY,
    COUNTRY
}

enum class ActionType{
    FOLLOW,
    UNFOLLOW,
}

data class SubmissionType(
    val mainData: Pair<String, DataType>?,
    val action: ActionType?,
)

val topicFlows = MutableSharedFlow<SubmissionType>().apply {
    resetReplayCache()
}


val topicFlowsState = MutableStateFlow<SubmissionType>(
    SubmissionType(
        null,
        null
    )
)

val mapOfChips = mutableMapOf<String, Chip>()

