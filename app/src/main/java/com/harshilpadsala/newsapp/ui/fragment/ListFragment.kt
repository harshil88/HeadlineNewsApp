package com.harshilpadsala.newsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}