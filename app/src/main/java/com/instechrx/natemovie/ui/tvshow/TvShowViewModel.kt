package com.instechrx.natemovie.ui.tvshow

import androidx.lifecycle.ViewModel
import com.instechrx.natemovie.utils.DummyDataTvShow

class TvShowViewModel : ViewModel() {

    fun getTvShow() = DummyDataTvShow.getTvShow()

}