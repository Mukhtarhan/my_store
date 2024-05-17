package com.example.myapplication.network


import com.example.myapplication.model.Meal
import retrofit2.http.GET
import retrofit2.Call


interface ProductService {
    @GET("products")
    fun getProducts(): Call<List<Meal>>
}
