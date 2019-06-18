package com.example.notekeeper2.Services

import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

class FakeUserResponse {

    @SerializedName("userid")
    var userid: String = ""
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String = ""
    @SerializedName("completed")
    var completed: Boolean = false

    override fun toString(): String {
        val strBuilder = StringBuilder()
        strBuilder.append("{userid: $userid,")
            .append("id: $id,")
            .append("title: $title,")
            .append("completed: $completed}")
        return strBuilder.toString()
    }
}