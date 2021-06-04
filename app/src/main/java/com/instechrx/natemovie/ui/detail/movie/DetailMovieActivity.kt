package com.instechrx.natemovie.ui.detail.movie

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.instechrx.natemovie.R
import com.instechrx.natemovie.databinding.ActivityDetailMovieBinding
import com.instechrx.natemovie.models.MoviesModel
import java.text.NumberFormat
import java.util.*


class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val MOVIE_TITLE = "movie_title"
    }
    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val title = intent.getStringExtra(MOVIE_TITLE)
        if (title != null) {
            detailMovieViewModel.setItem(title)
        }
        binding.collapsingToolbar.title = title
        binding.collapsingToolbar.setCollapsedTitleTextColor(
            ContextCompat.getColor(this, R.color.navy)
        )
        binding.collapsingToolbar.setExpandedTitleColor(
            ContextCompat.getColor(this, R.color.lightGray)
        )

        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)
        binding.toolbar.setNavigationOnClickListener { finish() }

        val movie : MoviesModel = detailMovieViewModel.getItem()
        bindData(movie)
    }
    private fun bindData(movie: MoviesModel?) {
        with(binding) {
            if (movie != null) {
                tvTitle.text = movie.title
                tvDirector.text = movie.directors
                tvGenre.text = movie.genre
                tvStoryLine.text = movie.storyLine
                tvHours.text = movie.hours
                val budget = movie.budget
                val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
                tvBudget.text = convertBudget

                val rate = movie.star.toDouble().div(10)
                tvStar.text = rate.toString()
                Glide.with(this@DetailMovieActivity)
                    .load(movie.poster)
                    .transform(CenterCrop())
                    .placeholder(ColorDrawable(Color.GRAY))
                    .into(ivPoster)
            }
        }
    }
}