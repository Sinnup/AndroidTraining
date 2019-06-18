package com.example.notekeeper2.Services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FakeUserService {

    @Headers("content-type: String/JSON",
        "Cache-Control: max-age=640000")
    @GET("todos/{userid}")
    fun getUser(@Path("userid") userid : String) : Call<FakeUserResponse>
}