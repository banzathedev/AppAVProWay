package com.proway.appav.services

import com.proway.appav.model.Products
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofitProducts = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getProducts(): ProductsService {
        return retrofitProducts.create(ProductsService::class.java)
    }


}