package com.harshilpadsala.newsapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.databinding.DataBindingUtil
import com.harshilpadsala.newsapp.BR

abstract class BaseActivity<VM : BaseViewModel , VDB : ViewDataBinding>(@LayoutRes private val layoutId : Int) : AppCompatActivity()
{
    abstract val viewmodel : VM
    protected lateinit var binding : VDB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewmodel)



    }
}