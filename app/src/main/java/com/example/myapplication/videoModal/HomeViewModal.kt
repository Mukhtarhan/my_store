package com.example.myapplication.videoModal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myapplication.model.Product
import com.example.myapplication.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModal():ViewModel() {
    private var overviewProductLiveData = MutableLiveData<Product>()
    fun getOverviewProduct() {
        val client = ApiClient.productService
        client.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.body() != null) {
                    val overviewProduct: Product = response.body()!![10]
                    Log.d("DATA", overviewProduct.image)
                    overviewProductLiveData.value = overviewProduct
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("TAG", "Failed to get overview product data", t)
            }
        })
    }
    fun observeLiveData():LiveData<Product>{
        return overviewProductLiveData
    }
}