package com.example.onlincecoffeeshopapp.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlincecoffeeshopapp.Activity.CartActivity
import com.example.onlincecoffeeshopapp.Adapter.CategoryAdapter
import com.example.onlincecoffeeshopapp.Adapter.OfferAdapter
import com.example.onlincecoffeeshopapp.Adapter.PopularAdapter
import com.example.onlincecoffeeshopapp.ViewModel.HomeViewModel
import com.example.onlincecoffeeshopapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private val viewModel=HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategory()
        initPopular()
        initOffer()
        goToCart()

    }

    private fun goToCart() {
        binding.cart.setOnClickListener {
            val intent=Intent(context,CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initOffer() {
        binding.progressBarOffer.visibility=View.VISIBLE
        viewModel.offer.observe(viewLifecycleOwner, Observer {
            binding.recyclerView3.apply {
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter=OfferAdapter(it)

            }
            binding.progressBarOffer.visibility=View.GONE
        })
        viewModel.loadOffer()
    }

    private fun initPopular() {
        binding.progressBarPopular.visibility=View.VISIBLE
        viewModel.popular.observe(viewLifecycleOwner, Observer {
            binding.recyclerView2.apply {
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter=PopularAdapter(it)

            }
            binding.progressBarPopular.visibility=View.GONE
        })
        viewModel.loadPopular()
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility=View.VISIBLE
        viewModel.category.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.apply {
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter=CategoryAdapter(it)

            }
            binding.progressBarCategory.visibility=View.GONE
        })
        viewModel.loadCategoyr()
    }

}