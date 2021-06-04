package com.instechrx.natemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.instechrx.natemovie.ui.movies.MoviesListViewHolder
import com.instechrx.natemovie.ui.movies.OnItemClickCallback
import com.instechrx.natemovie.databinding.ItemVerticalBinding
import com.instechrx.natemovie.models.MoviesModel

class ListMovieAdapter(private val listItem: ArrayList<MoviesModel>) : RecyclerView.Adapter<MoviesListViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val itemBinding =
            ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}