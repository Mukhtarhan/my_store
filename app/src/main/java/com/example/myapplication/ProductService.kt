package com.example.myapplication

import com.google.android.gms.analytics.ecommerce.Product
import retrofit2.http.GET
import retrofit2.Call

interface ProductService {
    @GET("/products")
    fun getProducts(): Call<List<Product>>
}
