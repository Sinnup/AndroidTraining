package com.example.notekeeper2

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

    private val TAG: String = this.javaClass.simpleName

    @Test
    fun addition_isCorrect() {
        //Log.i(TAG, "addition_isCorrect")
        System.out.println("addition_isCorrect")
        assertEquals(4, 2 + 2)

    }

    @Test
    fun dataManager_ContainsData() {
        System.out.println("dataManager_ContainsData")
        val dataManager = DataManager()
        assertNotNull(dataManager.courses)
        assertTrue(dataManager.courses.size > 1)
    }

}

