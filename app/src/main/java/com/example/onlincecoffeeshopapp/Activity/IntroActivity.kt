package com.example.onlincecoffeeshopapp.Activity

import android.content.Intent
import android.os.Bundle
import com.example.onlincecoffeeshopapp.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startMain()
    }
    private fun startMain() {
        binding.startBtn.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}