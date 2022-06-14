package com.harshilpadsala.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.google.android.material.chip.Chip
import com.harshilpadsala.newsapp.CountriesFlagItemDecorator
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.adapter.CountriesListAdapter
import com.harshilpadsala.newsapp.databinding.FragmentCountriesPageBinding
import com.harshilpadsala.newsapp.flows.*
import com.harshilpadsala.newsapp.vm.BottomNavViewModel
import kotlinx.coroutines.launch


class CountriesPageFragment : Fragment() {

    private lateinit var binding: FragmentCountriesPageBinding

    private val viewModel : BottomNavViewModel by navGraphViewModels(R.id.bottom_nav_graph){
        defaultViewModelProviderFactory
    }

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
           onFollowButtonClicked =  {
               lifecycleScope.launch {
                   emitFollow(it.name, ActionType.FOLLOW)
               }
            },

            onUnFollowItemClicked = {
                lifecycleScope.launchWhenStarted {
                    emitFollow(it.name , ActionType.UNFOLLOW)
                }
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

    private fun emitFollow(name : String, actionType: ActionType){
        Log.i("FlowDebug" , "THe emit Follow method is being run")
    }
}