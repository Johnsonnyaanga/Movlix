package com.johnson.movlix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.johnson.commons.utils.Constants.IMG_URL_INIT_PATH
import com.johnson.domain.models.Result
import com.johnson.movlix.databinding.MovieViewBinding

class TrendingMoviesAdapter:RecyclerView.Adapter<TrendingMoviesAdapter.TrendingMoviesViewHolder>() {
    class TrendingMoviesViewHolder(val binding:MovieViewBinding):RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieViewBinding = MovieViewBinding.inflate(layoutInflater, parent,false)
        return TrendingMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingMoviesViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            Glide.with(this.root)
                .load(IMG_URL_INIT_PATH+item.poster_path)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(movieLogo)

            movieTitle.text = item.title

        }


    }

    override fun getItemCount() = differ.currentList.size

}