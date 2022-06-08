package com.harshilpadsala.newsapp

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CountriesFlagItemDecorator(
    val equalPaddingHeight : Int
) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = equalPaddingHeight
        outRect.right = equalPaddingHeight
        outRect.bottom = equalPaddingHeight
        outRect.top = equalPaddingHeight
    }

}