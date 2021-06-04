package com.instechrx.natemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instechrx.natemovie.ui.movies.OnItemClickCallback
import com.instechrx.natemovie.databinding.ItemHorizontalBinding
import com.instechrx.natemovie.models.MoviesModel
import com.instechrx.natemovie.ui.movies.MoviesHorizontalViewHolder

class CardMovieAdapter(private val listItem: ArrayList<MoviesModel>) : RecyclerView.Adapter<MoviesHorizontalViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHorizontalViewHolder {
        val itemBinding =
            ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesHorizontalViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: MoviesHorizontalViewHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }
    override fun getItemCount() = listItem.size
}