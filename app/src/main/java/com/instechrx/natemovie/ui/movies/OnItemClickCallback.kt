package com.instechrx.natemovie.ui.movies

import com.instechrx.natemovie.models.MoviesModel


interface OnItemClickCallback {
    fun onItemClicked(movie : MoviesModel )
}