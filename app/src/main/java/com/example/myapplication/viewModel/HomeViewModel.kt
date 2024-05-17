package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Product
import com.example.myapplication.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel():ViewModel() {
    private var randomProductLiveData = MutableLiveData<Product>()
    fun getRandomProduct(){
        ApiClient.productService.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.body() != null) {
                    val randomProduct: Product = response.body()!![6]
                    randomProductLiveData.value = randomProduct
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("HomeFragment", t.message.toString())
            }
        })
    }
    fun observeRandomProductLivedata(): LiveData<Product> {
        return randomProductLiveData
    }
}