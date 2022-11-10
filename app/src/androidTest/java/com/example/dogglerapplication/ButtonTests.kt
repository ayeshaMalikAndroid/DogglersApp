package com.example.dogglerapplication
import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import junit.framework.AssertionFailedError
import kotlinx.coroutines.InternalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException

@InternalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
class ButtonTests {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `vertical_list_button_is_displayed`() {

        onView(withId(R.id.vertical_btn))
             .waitUntilVisible(5000)
            .check(matches(isDisplayed()))

       //Thread.sleep(5500);
     SystemClock.sleep(1500);
    }

    @Test
    fun `horizontal_list_button_is_displayed`() {
        onView(withId(R.id.horizontal_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun `grid_list_button_is_displayed`() {
        onView(withId(R.id.grid_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun `clicking_vertical_list_button_displays_vertical_list`() {
        onView(withId(R.id.vertical_btn)).perform(click())
        onView(withId(R.id.vertical_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun `clicking_horizontal_list_button_displays_horizontal_list`() {

        onView(withId(R.id.horizontal_btn))

            .waitUntilVisible(1500)
            .perform(click())

        SystemClock.sleep(1500)
        onView(withId(R.id.horizontal_recycler_view)).check(matches(isDisplayed()))
        SystemClock.sleep(1500)
    }

    @Test
    fun `clicking_grid_list_button_displays_grid_list`() {
        onView(withId(R.id.grid_btn)).perform(click())
        onView(withId(R.id.grid_recycler_view)).check(matches(isDisplayed()))
    }
    /**
     * Wait for view to be visible
     */
    fun ViewInteraction.waitUntilVisible(timeout: Long): ViewInteraction {
        val startTime = System.currentTimeMillis()
        val endTime = startTime + timeout

        do {
            try {
                check(matches(isDisplayed()))
                return this
            } catch (e: AssertionFailedError) {
                Thread.sleep(50)
            }
        } while (System.currentTimeMillis() < endTime)

        throw TimeoutException()
    }


}