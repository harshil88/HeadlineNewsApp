package com.harshilpadsala.newsapp.ui.fragment


import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.base.BaseFragment
import com.harshilpadsala.newsapp.databinding.FragmentHomePageBinding
import com.harshilpadsala.newsapp.vm.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomePageFragment : BaseFragment<HomeViewModel, FragmentHomePageBinding>(
    R.layout.fragment_home_page
)
{

    override val viewModel : HomeViewModel by viewModel()

    override fun setViewModel() {
        binding.viewModel = viewModel
    }






}