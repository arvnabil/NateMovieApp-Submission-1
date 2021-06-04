package com.instechrx.natemovie.ui.movies

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.instechrx.natemovie.databinding.ItemHorizontalBinding
import com.instechrx.natemovie.models.MoviesModel

class MoviesHorizontalViewHolder(private val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MoviesModel) {
        with(binding) {
            tvGenres.text = movie.genre
            tvTitle.text = movie.title
            tvTime.text = movie.hours
            val rate = movie.star.toDouble().div(10)
            tvRate.text = rate.toString()

            Glide.with(itemView.context)
                .load(movie.poster)
                .transform(CenterCrop(), RoundedCorners(15))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)

        }

    }
}
