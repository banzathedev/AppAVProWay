package com.proway.appav.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: UserName
)

data class UserName(

    val firstname: String,
    val lastname: String,
)
