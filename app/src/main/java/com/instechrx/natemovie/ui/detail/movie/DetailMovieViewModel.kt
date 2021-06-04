package com.instechrx.natemovie.ui.detail.movie

import androidx.lifecycle.ViewModel
import com.instechrx.natemovie.models.MoviesModel
import com.instechrx.natemovie.utils.DummyDataMovies

class DetailMovieViewModel : ViewModel(){

    private lateinit var itemMovie : MoviesModel
    fun setItem(title : String){
        val dummyDataMovie = DummyDataMovies.getMovie()
        itemMovie = dummyDataMovie.first { it.title == title }
    }
    fun getItem():MoviesModel{
        return itemMovie
    }

}