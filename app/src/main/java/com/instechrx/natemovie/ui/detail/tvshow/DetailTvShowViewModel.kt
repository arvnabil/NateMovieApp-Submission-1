package com.instechrx.natemovie.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import com.instechrx.natemovie.models.TVShowModel
import com.instechrx.natemovie.utils.DummyDataTvShow

class DetailTvShowViewModel : ViewModel(){

    private lateinit var itemTvShow : TVShowModel
    fun setItem(title : String){
        val dummyDataTvShow = DummyDataTvShow.getTvShow()
        itemTvShow = dummyDataTvShow.first { it.title == title }
    }
    fun getItem():TVShowModel{
        return itemTvShow
    }

}