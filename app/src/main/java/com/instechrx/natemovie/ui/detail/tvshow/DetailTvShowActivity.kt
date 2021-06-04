package com.instechrx.natemovie.ui.detail.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.instechrx.natemovie.R
import com.instechrx.natemovie.databinding.ActivityDetailTvshowBinding
import com.instechrx.natemovie.models.TVShowModel
import java.util.*


class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val TV_SHOW_TITLE = "tv_show"
    }
    private lateinit var binding: ActivityDetailTvshowBinding
    private val detailTvShowViewModel: DetailTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val title = intent.getStringExtra(TV_SHOW_TITLE)
        if (title != null) {
            detailTvShowViewModel.setItem(title)
        }
        binding.collapsingToolbar.title = title
        binding.collapsingToolbar.setCollapsedTitleTextColor(
            ContextCompat.getColor(this, R.color.navy)
        )
        binding.collapsingToolbar.setExpandedTitleColor(
            ContextCompat.getColor(this, R.color.lightGray)
        )
        //Set icon to toolbar
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)
        binding.toolbar.setNavigationOnClickListener { finish() }

        val tvshow : TVShowModel = detailTvShowViewModel.getItem()
        bindData(tvshow)
    }
    private fun bindData(tvShow: TVShowModel) {
        with(binding) {
            tvTitle.text = tvShow.title
            tvCreator.text = tvShow.creator
            tvGenre.text = tvShow.genre
            tvStoryLine.text = tvShow.storyLine
            tvHours.text = tvShow.hours

            val rate = tvShow.star.toDouble().div(10)
            tvStar.text = rate.toString()
            Glide.with(this@DetailTvShowActivity)
                .load(tvShow.poster)
                .transform(CenterCrop())
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)
        }
    }
}