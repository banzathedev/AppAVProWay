package com.proway.appav.services


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProducts(): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    fun getUser(): UserService {
        return retrofit.create(UserService::class.java)
    }


}