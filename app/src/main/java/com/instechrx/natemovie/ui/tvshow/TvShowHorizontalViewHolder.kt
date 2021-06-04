package com.instechrx.natemovie.ui.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.instechrx.natemovie.databinding.ItemHorizontalBinding
import com.instechrx.natemovie.models.TVShowModel

class TvShowHorizontalViewHolder(private val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TVShowModel) {
        with(binding) {
            tvGenres.text = tvShow.genre
            tvTitle.text = tvShow.title
            tvTime.text = tvShow.hours
            val rate = tvShow.star.toDouble().div(10)
            tvRate.text = rate.toString()

            Glide.with(itemView.context)
                .load(tvShow.poster)
                .transform(CenterCrop(), RoundedCorners(15))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)
        }

    }
}
