package com.example.notekeeper2.ui.activitydelete

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notekeeper2.R

class ActivityDeleteFragment : Fragment() {

    companion object {
        fun newInstance() = ActivityDeleteFragment()
    }

    private lateinit var viewModel: ActivityDeleteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.activity_delete_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActivityDeleteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
