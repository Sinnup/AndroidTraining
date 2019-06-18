package com.example.notekeeper2

import com.google.gson.annotations.SerializedName

class UsersList {

    @SerializedName("items")
    var users: List<User>? = null
}