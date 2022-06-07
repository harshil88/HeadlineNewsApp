package com.harshilpadsala.newsapp.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.getDrawableOrThrow
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.databinding.ViewCategoryCardViewBinding
import com.harshilpadsala.newsapp.state.CategoryState

@SuppressLint("ResourceType")
class CustomCardLayout(
    context: Context,
    attrs: AttributeSet)
    : CardView(context, attrs){
        init {
            inflate(context , R.layout.view_category_card_view , this)
            val customAttributesStyle = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomCardLayout,
                0,
                0,
            )

            val cardText = findViewById<TextView>(R.id.categoryText)
            val cardImage = findViewById<ImageView>(R.id.categoryImage)

            try {
                cardText.text = customAttributesStyle.getString(R.styleable.CustomCardLayout_cardText)
                cardImage.setImageDrawable(
                    customAttributesStyle.getDrawable(R.styleable.CustomCardLayout_cardImageDrawable)
                )
            }
            finally {
                customAttributesStyle.recycle()
            }
        }
    }

