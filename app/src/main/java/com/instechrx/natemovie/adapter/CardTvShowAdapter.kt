package com.instechrx.natemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instechrx.natemovie.databinding.ItemHorizontalBinding
import com.instechrx.natemovie.models.TVShowModel
import com.instechrx.natemovie.ui.tvshow.OnItemClickCallback
import com.instechrx.natemovie.ui.tvshow.TvShowHorizontalViewHolder

class CardTvShowAdapter(private val listItem: ArrayList<TVShowModel>) : RecyclerView.Adapter<TvShowHorizontalViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHorizontalViewHolder {
        val itemBinding =
            ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowHorizontalViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: TvShowHorizontalViewHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }
    override fun getItemCount() = listItem.size
}