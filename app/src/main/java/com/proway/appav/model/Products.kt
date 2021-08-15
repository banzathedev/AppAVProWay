package com.proway.appav.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String
)
