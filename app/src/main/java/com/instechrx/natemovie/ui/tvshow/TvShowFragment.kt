package com.instechrx.natemovie.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.instechrx.natemovie.R
import com.instechrx.natemovie.adapter.CardTvShowAdapter
import com.instechrx.natemovie.adapter.ListTVShowAdapter
import com.instechrx.natemovie.databinding.FragmentTvShowBinding
import com.instechrx.natemovie.models.TVShowModel
import com.instechrx.natemovie.ui.detail.tvshow.DetailTvShowActivity

class TvShowFragment : Fragment() {
    private val tvShowViewModel: TvShowViewModel by activityViewModels()
    private lateinit var adapter: ListTVShowAdapter
    private lateinit var adapterCard: CardTvShowAdapter
    private lateinit var binding: FragmentTvShowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
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
            val listTvShow : ArrayList<TVShowModel> = tvShowViewModel.getTvShow()
            adapter = ListTVShowAdapter(listTvShow)
            adapter.notifyDataSetChanged()
            binding.rvList.adapter = adapter
            adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(tvShow: TVShowModel) {
                            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                            intent.putExtra(DetailTvShowActivity.TV_SHOW_TITLE, tvShow.title)
                            startActivity(intent)
                        }
                    }
            )
        }
    }

    private fun itemListHorizontal() {
        binding.rvTvShow.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        activity.apply {
            val listMovie : ArrayList<TVShowModel> = tvShowViewModel.getTvShow()
            adapterCard = CardTvShowAdapter(listMovie)
            adapterCard.notifyDataSetChanged()
            binding.rvTvShow.adapter = adapterCard
            adapterCard.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(tvShow: TVShowModel) {
                            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                            intent.putExtra(DetailTvShowActivity.TV_SHOW_TITLE, tvShow.title)
                            startActivity(intent)
                        }
                    }
            )
        }
    }
}