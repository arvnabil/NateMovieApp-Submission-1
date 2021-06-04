package com.instechrx.natemovie.ui.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.instechrx.natemovie.databinding.ItemVerticalBinding
import com.instechrx.natemovie.models.TVShowModel

class TvShowListViewHolder(private val binding: ItemVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: TVShowModel) {
        with(binding) {
            tvGenre.text = movie.genre
            tvTitle.text = movie.title
            tvHours.text = movie.hours
            Glide.with(itemView.context)
                .load(movie.poster)
                .transform(CenterCrop(), RoundedCorners(15))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)
        }

    }
}
