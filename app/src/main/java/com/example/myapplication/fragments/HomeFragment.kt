package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Product
import com.example.myapplication.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var productList: List<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ApiClient.productService.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.body() != null) {
                    val randomProduct: Product = response.body()!![6]
                    with(binding) {
                        Glide
                            .with(root.context)
                            .load(randomProduct.images[0])
                            .into(imgRandomMeal)

                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                productList = ApiClient.productService.getProducts().toMutableList()
//                // Handle the successful response:
//                Log.d("result", productList[0].images[0])
//                with(binding) {
//                    Glide
//                        .with(root.context)
//                        .load(productList[0].images[0])
//                        .into(imgRandomMeal)
//                }
//
//            } catch (e: Exception) {
//                // Handle network errors or other exceptions
//                println("Error fetching dogs: $e")
//            }
//        }
    }
}