package com.example.notekeeper2;

import retrofit2.http.GET;
import retrofit2.Call;

public interface Api {

    //urls
    @GET("users?q=rokano")
    Call<UsersList> getUsers();
}