package com.harshilpadsala.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.databinding.FragmentTabBarBinding

class TabBarFragment : Fragment() {

    private lateinit var binding : FragmentTabBarBinding
    private lateinit var tabViewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentTabBarBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout = binding.tlExplore
        val viewPager = binding.exploreViewpager
        tabViewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = tabViewPagerAdapter


        TabLayoutMediator(tabLayout , viewPager){
                tab, position ->
            when(position){
                0 -> tab.text = "Category"
                1 -> tab.text = "Countries"
            }
        }.attach()

    }

}


class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        Log.i("VPrun" , "THis is running")
        return when(position){

            0 -> ExplorePageFragment()
            1 -> CountriesPageFragment()
            else -> ExplorePageFragment()
        }
    }
}