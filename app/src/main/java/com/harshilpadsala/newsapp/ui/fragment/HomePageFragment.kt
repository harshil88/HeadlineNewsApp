package com.harshilpadsala.newsapp.ui.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navGraphViewModels
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.adapter.AllNewsListAdapter
import com.harshilpadsala.newsapp.base.BaseFragment
import com.harshilpadsala.newsapp.databinding.FragmentHomePageBinding
import com.harshilpadsala.newsapp.flows.ActionType
import com.harshilpadsala.newsapp.flows.mapOfChips
import com.harshilpadsala.newsapp.flows.topicFlows
import com.harshilpadsala.newsapp.vm.BottomNavViewModel
import com.harshilpadsala.newsapp.vm.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent


class HomePageFragment : Fragment(
    R.layout.fragment_home_page
), KoinComponent
{
    val viewModel : BottomNavViewModel by navGraphViewModels(R.id.bottom_nav_graph){
    defaultViewModelProviderFactory
}

    private val secondViewModel  : HomeViewModel by viewModel()
    private lateinit var binding  : FragmentHomePageBinding
    private lateinit var adapter: AllNewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentHomePageBinding.inflate(
            inflater,
            container,
            false
        )


         adapter = AllNewsListAdapter()

        binding.allNewsRv.adapter = adapter

        return binding.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                secondViewModel.newsFlow.collect{
                    Log.i("DiffUtil" , "Keeps collecting from fragment")
                    adapter.submitList(it)
                }
            }
        }

    }
        }
