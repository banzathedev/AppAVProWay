package com.proway.appav.services

import com.proway.appav.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("/users/1")
    fun getUserEndpoint(): Call<User>
}
