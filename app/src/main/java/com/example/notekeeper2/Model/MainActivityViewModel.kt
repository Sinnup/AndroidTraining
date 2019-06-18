package com.example.notekeeper2.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val TAG: String = this.javaClass.simpleName
    private var dataLoaded : MutableLiveData<String>? = null

    fun getDataLoaded(data: String = "ViewModel in action"): MutableLiveData<String> {
        Log.i(TAG, "Getting data")
        if (dataLoaded == null){
            dataLoaded = MutableLiveData()
            setDataLoaded(data)
        }
        return this.dataLoaded!!
    }

    private fun setDataLoaded(data: String) {
        Log.i(TAG, "Setting data")
        this.dataLoaded!!.value = data

    }

    fun insertDataLoaded(data : String){
        this.dataLoaded!!.value = data
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "ViewModel Destroyed")
    }
}