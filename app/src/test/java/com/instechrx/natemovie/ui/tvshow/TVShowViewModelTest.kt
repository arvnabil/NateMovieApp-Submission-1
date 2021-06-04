package com.instechrx.natemovie.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TVShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getListMovie() {

        val tvShowEntities = viewModel.getTvShow()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(10, tvShowEntities.size)

    }
}