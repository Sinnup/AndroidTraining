package com.example.notekeeper2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notekeeper2.ui.activitydelete.ActivityDeleteFragment

class ActivityDelete : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ActivityDeleteFragment.newInstance())
                .commitNow()
        }
    }

}
