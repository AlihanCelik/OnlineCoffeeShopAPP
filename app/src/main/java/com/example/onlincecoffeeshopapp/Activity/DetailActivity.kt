package com.example.onlincecoffeeshopapp.Activity

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.RequestOptions
import com.example.onlincecoffeeshopapp.Adapter.SizeAdapter
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.R
import com.example.onlincecoffeeshopapp.databinding.ActivityDetailBinding
import com.example.project1762.Helper.ManagmentCart

class DetailActivity : BaseActivity() {
    private lateinit var binding:ActivityDetailBinding
    private lateinit var item:ItemsModel
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()
        initSizeList()

    }

    private fun initSizeList() {
        val sizeList=ArrayList<String>()
        sizeList.add("1")
        sizeList.add("2")
        sizeList.add("3")
        sizeList.add("4")
        binding.recwSize.apply {
            adapter=SizeAdapter(sizeList)
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
        var colorList=ArrayList<String>()
        for(imageUrl in item.picUrl){
            colorList.add(imageUrl)
        }
        Glide.with(this).load(colorList[0]).apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(binding.imgDetail)
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