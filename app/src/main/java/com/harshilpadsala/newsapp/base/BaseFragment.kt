package com.harshilpadsala.newsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel , VDB : ViewDataBinding>
    (@LayoutRes private val layoutId : Int) : Fragment() {

    abstract val viewModel : VM
    abstract fun setViewModel()
    protected lateinit var binding: VDB
    var bindingView : View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(bindingView == null){
            binding = DataBindingUtil.inflate(
                inflater,
                layoutId,
                container,
                false
            )
            binding.lifecycleOwner = this
            setViewModel()
            bindingView = binding.root
        }
        return bindingView
    }

}