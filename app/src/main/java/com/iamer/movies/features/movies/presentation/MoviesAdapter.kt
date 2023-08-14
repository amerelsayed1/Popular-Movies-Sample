package com.iamer.movies.features.movies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamer.movies.R
import com.iamer.movies.databinding.ItemMovieBinding
import com.iamer.movies.features.movies.data.models.Movie


class MoviesAdapter : ListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MovieViewHolder
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Movie?) {
            binding.tvMovieTitle.text = data?.title
            binding.tvMovieOverView.text = data?.overview
            Glide
                .with(binding.ivMovieImg.context)
                .load(data?.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(binding.ivMovieImg);
        }
    }

    object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }


}

