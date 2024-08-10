package com.example.onlincecoffeeshopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.databinding.ItemOfferBinding

class OfferAdapter(val items:MutableList<ItemsModel>):RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {
    private lateinit var context:Context
    class OfferViewHolder(val binding: ItemOfferBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        context=parent.context
        val binding=ItemOfferBinding.inflate(LayoutInflater.from(context),parent,false)
        return OfferViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        var item=items[position]
        holder.binding.titleOffer.text=item.title
        Glide.with(context).load(item.picUrl[0]).into(holder.binding.imgOffer)
        holder.binding.priceOffer.text="$"+item.price
        holder.itemView.setOnClickListener {

        }
    }
}