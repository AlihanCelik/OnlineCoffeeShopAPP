package com.example.onlincecoffeeshopapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlincecoffeeshopapp.Activity.DetailActivity
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.databinding.ActivityMainBinding
import com.example.onlincecoffeeshopapp.databinding.ItemCatgoryBinding
import com.example.onlincecoffeeshopapp.databinding.ItemPopularBinding

class PopularAdapter(val items:MutableList<ItemsModel>):RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    private lateinit var context: Context
    class PopularViewHolder(var binding: ItemPopularBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        context=parent.context
        val binding=ItemPopularBinding.inflate(LayoutInflater.from(context),parent,false)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        var item=items[position]
        holder.binding.titleItem.text=item.title
        holder.binding.itemDesc.text=item.extra
        holder.binding.itemPrice.text="$"+item.price.toString()
        holder.binding.ratingBarItem.rating=items[position].rating.toFloat()
        Glide.with(context).load(item.picUrl[0]).into(holder.binding.shapeableImageView)
        holder.itemView.setOnClickListener {
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra("object",item)
            context.startActivity(intent)
        }

    }
}