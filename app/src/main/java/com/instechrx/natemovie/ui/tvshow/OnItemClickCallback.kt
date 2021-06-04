package com.instechrx.natemovie.ui.tvshow

import com.instechrx.natemovie.models.TVShowModel

interface OnItemClickCallback {
    fun onItemClicked(tvShow : TVShowModel)
}