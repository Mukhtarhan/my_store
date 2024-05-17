package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Meal
import com.example.myapplication.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel():ViewModel() {
    private var randomProductLiveData = MutableLiveData<Meal>()
    fun getRandomProduct(){
        ApiClient.productService.getProducts().enqueue(object : Callback<List<Meal>> {
            override fun onResponse(call: Call<List<Meal>>, response: Response<List<Meal>>) {
                if(response.body() != null) {
                    val randomProduct: Meal = response.body()!![6]
                    randomProductLiveData.value = randomProduct
                }
            }

            override fun onFailure(call: Call<List<Meal>>, t: Throwable) {
                Log.d("HomeFragment", t.message.toString())
            }
        })
    }
    fun observeRandomProductLivedata(): LiveData<Meal> {
        return randomProductLiveData
    }
}