package com.example.onlincecoffeeshopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.R
import com.example.onlincecoffeeshopapp.databinding.ItemSizeBinding

class SizeAdapter(val items:MutableList<String>):RecyclerView.Adapter<SizeAdapter.SizeViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition=-1
    private var lastSelectedPosition=-1
    inner class SizeViewHolder(val binding: ItemSizeBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        context=parent.context
        val binding=ItemSizeBinding.inflate(LayoutInflater.from(context),parent,false)
        return SizeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    private fun Int.dpToPx(context: Context):Int{
        return (this*context.resources.displayMetrics.density).toInt()
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        var ps=position
        holder.binding.root.setOnClickListener {
            lastSelectedPosition=selectedPosition
            selectedPosition=ps
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if(selectedPosition==ps){
            holder.binding.itemCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.orange))
        }else{
            holder.binding.itemCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.coffeeSize))
        }
        val imageSize=when(ps){
            0->45.dpToPx(context)
            1->50.dpToPx(context)
            2->55.dpToPx(context)
            3->65.dpToPx(context)
            else->70.dpToPx(context)
        }
        val layoutParams=holder.binding.itemImg.layoutParams
        layoutParams.width=imageSize
        layoutParams.height=imageSize
        holder.binding.itemImg.layoutParams=layoutParams
    }
}