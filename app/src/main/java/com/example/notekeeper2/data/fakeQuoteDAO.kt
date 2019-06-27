package com.example.notekeeper2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class fakeQuoteDAO {

    private val quoteLIst = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteLIst
    }

    fun addQuote(quote: Quote){
        quoteLIst.add(quote)
        quotes.value = quoteLIst
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>

}