package com.harshilpadsala.newsapp.model

data class CountryData(
    val name: String,
    val isoCode: String,
)

val countriesList = listOf<CountryData>(
    CountryData("India" , "in"),
    CountryData("USA" , "us"),
    CountryData("Japan" , "jp"),
    CountryData("Thailand" , "th")
)
