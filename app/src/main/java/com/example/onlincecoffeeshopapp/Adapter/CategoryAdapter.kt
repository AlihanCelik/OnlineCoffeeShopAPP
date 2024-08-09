package com.example.onlincecoffeeshopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlincecoffeeshopapp.Model.CategoryModel
import com.example.onlincecoffeeshopapp.R
import com.example.onlincecoffeeshopapp.databinding.ItemCatgoryBinding

class CategoryAdapter(val items:MutableList<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private lateinit var context: Context
    private var selectedPosition=-1
    private var lastSelectedPosition=-1
    inner class CategoryViewHolder(var binding: ItemCatgoryBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        context=parent.context
        val binding=ItemCatgoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var item=items[position]
        var ps=position
        holder.binding.itemCategory.text=item.title
        holder.binding.root.setOnClickListener {
            lastSelectedPosition=selectedPosition
            selectedPosition=ps
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

        }
        if(selectedPosition==ps){
            holder.binding.itemCategory.setBackgroundResource(R.drawable.orange_bg)
        }else{
            holder.binding.itemCategory.setBackgroundResource(R.drawable.edittext_bg)
        }
    }
}