package com.instechrx.natemovie.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.instechrx.natemovie.R
import com.instechrx.natemovie.adapter.CardMovieAdapter
import com.instechrx.natemovie.adapter.ListMovieAdapter
import com.instechrx.natemovie.databinding.FragmentMoviesBinding
import com.instechrx.natemovie.models.MoviesModel
import com.instechrx.natemovie.ui.detail.movie.DetailMovieActivity


class MoviesFragment : Fragment() {
    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var adapter: ListMovieAdapter
    private lateinit var adapterCard: CardMovieAdapter
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemListHorizontal()
        itemListVertical()
        Glide.with(this)
                .load(R.drawable.nabil)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_picture_empty)
                .into(binding.ivProfile)
    }

    private fun itemListVertical() {
        binding.rvList.layoutManager = LinearLayoutManager(activity)
        activity.apply {
            val listMovie : ArrayList<MoviesModel> = moviesViewModel.getMovie()
            adapter = ListMovieAdapter(listMovie)
            adapter.notifyDataSetChanged()
            binding.rvList.adapter = adapter
            adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(movie: MoviesModel) {
                            val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.MOVIE_TITLE, movie.title)
                            startActivity(intent)
                        }
                    }
            )
        }
    }

    private fun itemListHorizontal() {
        binding.rvMovies.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        activity.apply {
            val listMovie : ArrayList<MoviesModel> = moviesViewModel.getMovie()
            adapterCard = CardMovieAdapter(listMovie)
            adapterCard.notifyDataSetChanged()
            binding.rvMovies.adapter = adapterCard
            adapterCard.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(movie: MoviesModel) {
                            val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.MOVIE_TITLE, movie.title)
                            startActivity(intent)
                        }
                    }
            )
        }
    }
}