package com.instechrx.natemovie.ui.movies

import androidx.lifecycle.ViewModel
import com.instechrx.natemovie.utils.DummyDataMovies

class MoviesViewModel : ViewModel() {

    fun getMovie() = DummyDataMovies.getMovie()

}