package com.proway.appav.services

import com.proway.appav.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("/user/1") // TODO("Conferir retorno desse link")
    fun getUserEndpoint(): Call<User>
}
