package com.instechrx.natemovie.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.instechrx.natemovie.R
import com.instechrx.natemovie.utils.DummyDataMovies
import com.instechrx.natemovie.utils.DummyDataTvShow
import org.hamcrest.core.AllOf.allOf
import org.junit.Before
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class HomeActivityTest {
    private val dummyMovies = DummyDataMovies.getMovie()
    private val dummyTvShow = DummyDataTvShow.getTvShow()
    @Before
    fun set(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovie() {
        Espresso.onView(withId(R.id.rvMovies))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rvMovies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        Espresso.onView(withId(R.id.rvTvShow)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadListMovie() {
        Espresso.onView(withId(R.id.rvList))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rvList))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        Espresso.onView(withId(R.id.rvTvShow)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadListTvShow() {
        Espresso.onView(allOf(withId(R.id.navigation_tvshow),isDisplayed())).perform(click())
        Espresso.onView(withId(R.id.rvList))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rvList))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        Espresso.onView(withId(R.id.rvMovies)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadTVShow() {
        Espresso.onView(allOf(withId(R.id.navigation_tvshow),isDisplayed())).perform(click())
        Espresso.onView(withId(R.id.rvTvShow))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.rvTvShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
        Espresso.onView(withId(R.id.rvMovies)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        Espresso.onView(withId(R.id.ivPoster))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvTitle))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvTitle))
            .check(matches(withText(dummyMovies[0].title)))
        Espresso.onView(withId(R.id.tv_genre))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
            .check(matches(withText(dummyMovies[0].genre)))
        Espresso.onView(withId(R.id.tvDirector))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvDirector))
            .check(matches(withText(dummyMovies[0].directors)))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(matches(withText(dummyMovies[0].storyLine)))

        // Convert Value of Star
        val star = dummyMovies[0].star.toDouble().div(10)
        Espresso.onView(withId(R.id.tvStar))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvStar))
            .check(matches(withText(star.toString())))

        // Convert Value of Budget
        val budget = dummyMovies[0].budget
        val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
        Espresso.onView(withId(R.id.tvBudget))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvBudget))
            .check(matches(withText(convertBudget)))
    }

    @Test
    fun loadDetailTVShow() {
        Espresso.onView(allOf(withId(R.id.navigation_tvshow),isDisplayed())).perform(click())
        Espresso.onView(withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        Espresso.onView(withId(R.id.ivPoster))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvTitle))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvTitle))
            .check(matches(withText(dummyTvShow[0].title)))
        Espresso.onView(withId(R.id.tv_genre))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
            .check(matches(withText(dummyTvShow[0].genre)))
        Espresso.onView(withId(R.id.tvCreator))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvCreator))
            .check(matches(withText(dummyTvShow[0].creator)))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(matches(withText(dummyTvShow[0].storyLine)))
        // Convert Value of Star
        val star = dummyTvShow[0].star.toDouble().div(10)
        Espresso.onView(withId(R.id.tvStar))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.tvStar))
            .check(matches(withText(star.toString())))

    }
}