package com.example.notekeeper2


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.notekeeper2.ui.activity.MainActivity

import org.hamcrest.core.IsNot.not
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.runners.MethodSorters

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExampleInstrumentedTest {

    val INPUT_STRING : String = "This note is titled 'My Note'"

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

        @Test
        fun useAppContext() {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.notekeeper2", appContext.packageName)
        }

        @Test
        fun userWriteInNoteTitle(){
            onView(withId( R.id.textNoteTitle )).perform(typeText(INPUT_STRING))
            onView(withId( R.id.textNoteTitle )).check(matches(withText(INPUT_STRING)))
        }

    @Test
    fun fabClickedAndResponse(){
        onView(withId( R.id.fab )).perform(click())
        onView(withId( R.id.textNoteTitle )).perform(typeText(INPUT_STRING))
        onView(withId( R.id.textNoteTitle )).check(matches(withText(INPUT_STRING)))
        onView(withId( R.id.textDisplayedValue )).check(matches(not(withText("ViewModel in action"))))
        onView(withId( R.id.textDisplayedValue )).check(matches(withSubstring("EyeHunts")))
    }
}
