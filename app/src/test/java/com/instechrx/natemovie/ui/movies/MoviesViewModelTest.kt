package com.instechrx.natemovie.ui.movies


import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovie() {
       val moviesEntities = viewModel.getMovie()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities.size)

    }
}