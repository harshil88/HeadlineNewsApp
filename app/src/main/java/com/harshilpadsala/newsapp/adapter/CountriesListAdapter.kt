package com.harshilpadsala.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshilpadsala.newsapp.GlideApp
import com.harshilpadsala.newsapp.databinding.ViewCategoryCardViewBinding
import com.harshilpadsala.newsapp.model.CountryData
import com.harshilpadsala.newsapp.model.countriesList


class CountriesListAdapter(
    private val onFollowButtonClicked : (country : CountryData) -> Unit,
    private val onUnFollowItemClicked : (country : CountryData) -> Unit
) : RecyclerView.Adapter<CountriesListAdapter.CountryListViewHolder>(){

     class CountryListViewHolder(
        binding: ViewCategoryCardViewBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ){
        private val countryTextView = binding.categoryText
        private val countryFlagImageView = binding.categoryImage
        private val followingButton = binding.followButton
         private val unFollowingButton = binding.unfollowButton

        fun bind(
            countryModel : CountryData,
            followOnClick : (CountryData) -> Unit,
            unFollowOnClick : (CountryData) -> Unit,
        ){
            countryTextView.text = countryModel.name

            val url = "https://countryflagsapi.com/png/${countryModel.isoCode}"

            GlideApp.with(countryFlagImageView).load(url)
                .into(countryFlagImageView)

            followingButton.setOnClickListener {
                followOnClick
                followingButton.visibility = View.INVISIBLE
                unFollowingButton.visibility = View.VISIBLE
            }

            unFollowingButton.setOnClickListener {
                unFollowOnClick
                unFollowingButton.visibility = View.INVISIBLE
                followingButton.visibility = View.VISIBLE
            }
        }

         companion object{
             fun from(parent: ViewGroup) : CountryListViewHolder{
                 val inflater = LayoutInflater.from(parent.context)
                 val binding = ViewCategoryCardViewBinding.inflate(inflater, parent, false)
                 return CountryListViewHolder(binding)
             }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        return CountryListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val item = countriesList[position]
        holder.bind(item , onFollowButtonClicked, onUnFollowItemClicked)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }
}