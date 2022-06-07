package com.harshilpadsala.newsapp.constants

import androidx.annotation.DrawableRes
import com.harshilpadsala.newsapp.R

enum class NewsCategoryImage(@DrawableRes val drawableRes: Int) {
    BUSINESS(R.drawable.ic_business),
    SPORTS(R.drawable.ic_sports),
    ENTERTAINTMENT(R.drawable.ic_entertaintment),
    HEALTH(R.drawable.ic_health),
    SCIENCE(R.drawable.ic_science),
    TECHNOLOGY(R.drawable.ic_technology),
    GENERAL(R.drawable.ic_general)

}