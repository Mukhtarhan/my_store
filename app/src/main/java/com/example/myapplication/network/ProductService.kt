package com.example.myapplication.network


import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductList
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query


interface ProductService {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}
