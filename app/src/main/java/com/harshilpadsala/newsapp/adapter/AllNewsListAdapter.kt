package com.harshilpadsala.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.harshilpadsala.newsapp.GlideApp
import com.harshilpadsala.newsapp.data.response.News
import com.harshilpadsala.newsapp.databinding.ListTileNewsDisplayBinding

class AllNewsListAdapter(
//    private val onFollowButtonClicked : (country : CountryData) -> Unit,
) : ListAdapter<News, AllNewsListAdapter.AllNewsListViewHolder>(AllNewsDiffCallBack()){

    class AllNewsListViewHolder(
        binding: ListTileNewsDisplayBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    ){
        private val newsDescriptionTextView = binding.newsDescription
        private val newsReporterTextView = binding.newsReporter
        private val newsThumbnailImageView = binding.newsThumbnail
        private val newsCategoryTextView = binding.newsCategory

        fun bind(
            newsModel : News,
        ){
            newsDescriptionTextView.text = newsModel.description
            newsCategoryTextView.text = newsModel.publishedAt
            newsReporterTextView.text = newsModel.author
            GlideApp.with(newsThumbnailImageView).load(newsModel.urlToImage)
                .into(newsThumbnailImageView)
        }

        companion object{
            fun from(parent: ViewGroup) : AllNewsListViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListTileNewsDisplayBinding.inflate(inflater, parent, false)
                return AllNewsListViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNewsListViewHolder {
        return AllNewsListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AllNewsListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class AllNewsDiffCallBack : DiffUtil.ItemCallback<News>(){
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}