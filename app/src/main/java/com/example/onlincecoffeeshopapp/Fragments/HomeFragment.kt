package com.example.onlincecoffeeshopapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlincecoffeeshopapp.Adapter.CategoryAdapter
import com.example.onlincecoffeeshopapp.ViewModel.HomeViewModel
import com.example.onlincecoffeeshopapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private val viewModel=HomeViewModel()
    private lateinit var categoryAdapter: CategoryAdapter

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
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility=View.VISIBLE
        viewModel.category.observe(viewLifecycleOwner, Observer {
            binding.recyclerView.apply {
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter=CategoryAdapter(it)
                binding.progressBarCategory.visibility=View.GONE
            }
        })
        viewModel.loadCategoyr()
    }

}