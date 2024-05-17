package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentHomeBinding
<<<<<<< HEAD
import com.example.myapplication.model.Meal
import com.example.myapplication.viewModel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeMvvm: HomeViewModel
    private var productList: List<Meal> = mutableListOf()
    private lateinit var randomProduct: Meal


    companion object{
        const val PRODUCT_ID="com.example.myapplication.fragments.idProduct"
        const val PRODUCT_NAME="com.example.myapplication.fragments.nameProduct"
        const val PRODUCT_THUMB="com.example.myapplication.fragments.thumbProduct"


    }

=======
import com.example.myapplication.model.Product
import com.example.myapplication.network.ApiClient
import com.example.myapplication.videoModal.HomeViewModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeMvvm: HomeViewModal
    private var productList: List<Product> = mutableListOf()
>>>>>>> ae37d2b195f299518e9a21bb18e0d9f037201f0e

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMvvm = ViewModelProviders.of(this)[HomeViewModal::class.java]
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

        homeMvvm.getOverviewProduct()
        observeOverviewProduct()

    }
<<<<<<< HEAD

    private fun onRandomProductClick() {
        binding.randomProductCard.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
//            intent.putExtra(PRODUCT_ID,randomProduct.id)
//            intent.putExtra(PRODUCT_NAME,randomProduct.title)
//            intent.putExtra(PRODUCT_THUMB,randomProduct.)
            startActivity(intent)
        }
    }


    private fun observeRandomProduct() {
        homeMvvm.observeRandomProductLivedata().observe(viewLifecycleOwner, Observer { value ->
            if (value.images.isNotEmpty()) {
=======
    private fun observeOverviewProduct() {
        homeMvvm.observeLiveData().observe(viewLifecycleOwner, object :Observer<Product>{
            override fun onChanged(value: Product) {
>>>>>>> ae37d2b195f299518e9a21bb18e0d9f037201f0e
                Glide.with(this@HomeFragment)
                    .load(value.image)
                    .into(binding.imgRandomProduct)
//
//                this.randomProduct = value
            }
        })
    }
}