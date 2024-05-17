package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.activites.MainActivity
import com.example.myapplication.databinding.FragmentHomeBinding
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMvvm = ViewModelProvider(this).get(HomeViewModel::class.java)
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

        homeMvvm.getRandomProduct()
        observeRandomProduct()
        onRandomProductClick()
    }

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
                Glide.with(this@HomeFragment)
                    .load(value.images[0])
                    .into(binding.imgRandomProduct)
//
//                this.randomProduct = value
            }
        })
    }
}
