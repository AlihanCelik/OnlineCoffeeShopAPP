package com.example.onlincecoffeeshopapp.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlincecoffeeshopapp.R
import com.example.onlincecoffeeshopapp.databinding.ActivityCartBinding
import com.example.onlincecoffeeshopapp.databinding.ActivityDetailBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}