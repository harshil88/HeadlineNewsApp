package com.harshilpadsala.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.harshilpadsala.newsapp.CountriesFlagItemDecorator
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.adapter.CountriesListAdapter
import com.harshilpadsala.newsapp.databinding.FragmentCountriesPageBinding


class CountriesPageFragment : Fragment() {

    private lateinit var binding: FragmentCountriesPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCountriesPageBinding.inflate(
            inflater,
            container,
            false
        )
        val adapter = CountriesListAdapter(
            {(country) ->
                Log.i("AdapterDebug", "Follow Button Pressed")
            },
            {(country) ->
                Log.i("AdapterDebug" , "Unfollow Button Pressed")
            }
        )

        val layoutManager = binding.rvCountriesPage.layoutManager
        binding.rvCountriesPage.adapter = adapter

        val rvItemDecorator = CountriesFlagItemDecorator(16)
        binding.rvCountriesPage.addItemDecoration(
            rvItemDecorator
        )
        return binding.root
    }
}