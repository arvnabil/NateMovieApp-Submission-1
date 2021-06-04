package com.instechrx.natemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instechrx.natemovie.databinding.ItemVerticalBinding
import com.instechrx.natemovie.models.TVShowModel
import com.instechrx.natemovie.ui.tvshow.OnItemClickCallback
import com.instechrx.natemovie.ui.tvshow.TvShowListViewHolder

class ListTVShowAdapter(private val listItem: ArrayList<TVShowModel>) : RecyclerView.Adapter<TvShowListViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowListViewHolder {
        val itemBinding =
            ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowListViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: TvShowListViewHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }


}