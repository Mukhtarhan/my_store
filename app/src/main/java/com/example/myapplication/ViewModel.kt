//package com.example.myapplication
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.google.android.gms.analytics.ecommerce.Product
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class MainViewModel : ViewModel() {
//    private val products = MutableLiveData<List<Product>>()
//
//    fun loadProducts() {
//        ApiClient.productService.getProducts().enqueue(object : Callback<List<Product>> {
//            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//                if (response.isSuccessful) {
//                    products.postValue(response.body())
//                } else {
//                    // обрабатывайте ошибки запроса в зависимости от response.code() и response.message()
//                }
//            }
//
//            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
//                // обрабатывайте неудачу при подключении к сервису
//            }
//        })
//    }
//
//    // LiveData, которую наблюдает UI
//    fun getProducts(): LiveData<List<Product>> = products
//}