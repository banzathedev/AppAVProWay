package com.proway.appav.services

import com.proway.appav.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductsService {
    @GET("/products")
    fun getProductsAtApiEndpoint(): Call<List<Products>>
}