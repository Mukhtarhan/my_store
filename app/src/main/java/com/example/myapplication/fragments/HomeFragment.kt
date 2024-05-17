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
import com.example.myapplication.model.Product
import com.example.myapplication.viewModel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeMvvm: HomeViewModel
    private var productList: List<Product> = mutableListOf()

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
            startActivity(intent)
        }
    }


    private fun observeRandomProduct() {
        homeMvvm.observeRandomProductLivedata().observe(viewLifecycleOwner, Observer { value ->
            if (value.images.isNotEmpty()) {
                Glide.with(this@HomeFragment)
                    .load(value.images[0])
                    .into(binding.imgRandomProduct)
            }
        })
    }
}
