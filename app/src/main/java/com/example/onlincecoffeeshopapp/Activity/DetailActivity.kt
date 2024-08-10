package com.example.onlincecoffeeshopapp.Activity

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.R
import com.example.onlincecoffeeshopapp.databinding.ActivityDetailBinding
import com.example.project1762.Helper.ManagmentCart

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    private lateinit var item:ItemsModel
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()

    }

    private fun bundle() {
        binding.apply {
            item=intent.getParcelableExtra("object")!!
            detailTitle.text=item.title
            detailPrice.text="$"+item.price
            description.text=item.description
            ratingBar.rating=item.rating.toFloat()

            addToCart.setOnClickListener{
                item.numberInChart=Integer.valueOf(
                    detailNum.text.toString()
                )
                managmentCart.insertItems(item)
            }
            backBtn.setOnClickListener { finish() }
            detailIncrement.setOnClickListener {
                detailNum.text=(item.numberInChart+1).toString()
                item.numberInChart++
            }
            detailDecrement.setOnClickListener {
                if(item.numberInChart>0){
                    detailNum.text=(item.numberInChart-1).toString()
                    item.numberInChart--
                }
            }
        }

    }
}