package com.instechrx.natemovie.ui.detail.movie

import com.instechrx.natemovie.utils.DummyDataMovies
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyItem = DummyDataMovies.getMovie()[0]
    private val itemTitle = dummyItem.title

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setItem(itemTitle)
    }

    @Test
    fun getItem() {
        val itemEntity = viewModel.getItem()
        assertNotNull(itemEntity)
        assertEquals(dummyItem.title, itemEntity.title)
        assertEquals(dummyItem.star, itemEntity.star)
        assertEquals(dummyItem.poster, itemEntity.poster)
        assertEquals(dummyItem.budget, itemEntity.budget)
        assertEquals(dummyItem.directors, itemEntity.directors)
        assertEquals(dummyItem.hours, itemEntity.hours)
        assertEquals(dummyItem.genre, itemEntity.genre)
        assertEquals(dummyItem.storyLine, itemEntity.storyLine)
    }
}