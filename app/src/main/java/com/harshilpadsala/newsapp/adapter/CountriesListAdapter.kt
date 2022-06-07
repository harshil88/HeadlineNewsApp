package com.harshilpadsala.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshilpadsala.newsapp.GlideApp
import com.harshilpadsala.newsapp.R
import com.harshilpadsala.newsapp.databinding.ViewCategoryCardViewBinding
import com.harshilpadsala.newsapp.model.CountryData
import com.harshilpadsala.newsapp.model.countriesList


class CountriesListAdapter : RecyclerView.Adapter<CountriesListAdapter.CountryListViewHolder>(){

     class CountryListViewHolder(
        binding: ViewCategoryCardViewBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ){
        private val countryTextView = binding.categoryText
        private val countryFlagImageView = binding.categoryImage

        fun bind(countryModel : CountryData){
            countryTextView.text = countryModel.name
            GlideApp.with(countryFlagImageView).load("https://countryflagsapi.com/png/in")
                .into(countryFlagImageView)
        }

         companion object{
             fun from(parent: ViewGroup) : CountryListViewHolder{
                 val inflator = LayoutInflater.from(parent.context)
                 val binding = ViewCategoryCardViewBinding.inflate(inflator, parent, false)
                 return CountryListViewHolder(binding)
             }
         }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        return CountryListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val item = countriesList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }
}