package com.instechrx.natemovie.ui.detail.tvshow

import com.instechrx.natemovie.utils.DummyDataTvShow
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyItem = DummyDataTvShow.getTvShow()[0]
    private val itemTitle = dummyItem.title

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setItem(itemTitle)
    }

    @Test
    fun getItem() {
        val itemEntity = viewModel.getItem()
        assertNotNull(itemEntity)
        assertEquals(dummyItem.title, itemEntity.title)
        assertEquals(dummyItem.star, itemEntity.star)
        assertEquals(dummyItem.poster, itemEntity.poster)
        assertEquals(dummyItem.creator, itemEntity.creator)
        assertEquals(dummyItem.hours, itemEntity.hours)
        assertEquals(dummyItem.genre, itemEntity.genre)
        assertEquals(dummyItem.storyLine, itemEntity.storyLine)
    }
}