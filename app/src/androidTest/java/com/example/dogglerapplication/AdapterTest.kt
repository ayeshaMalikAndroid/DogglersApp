package com.example.dogglerapplication

import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AdapterTest {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun recycler(){
        onView(withId(R.id.grid_recycler_view))

            .perform(ViewActions.swipeUp())
        SystemClock.sleep(1500)
        onView(withText("Bella")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        SystemClock.sleep(1500)


    }
    @Test
    fun check() {
        onView(withText("Bella"))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
    }
}