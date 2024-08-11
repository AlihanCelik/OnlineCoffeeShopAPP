package com.example.onlincecoffeeshopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.onlincecoffeeshopapp.Helper.ChangeNumberItemsListener
import com.example.onlincecoffeeshopapp.Model.ItemsModel
import com.example.onlincecoffeeshopapp.databinding.ActivityCartBinding
import com.example.onlincecoffeeshopapp.databinding.ItemCartBinding
import com.example.project1762.Helper.ManagmentCart

class CartAdapter(
    private val listItemSelected:ArrayList<ItemsModel>,
    context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener? = null
):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    class CartViewHolder(val binding: ItemCartBinding):RecyclerView.ViewHolder(binding.root) {

    }
    private val managemntCart=ManagmentCart(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding=ItemCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemSelected.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item=listItemSelected[position]

        holder.binding.titleItem.text=item.title
        holder.binding.textView4.text="$"+item.price.toString()
        holder.binding.totalEachItem.text="$${Math.round(item.numberInChart * item.price)}"
        holder.binding.detailNum.text=item.numberInChart.toString()

        Glide.with(holder.itemView.context).load(item.picUrl[0]).apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.picCart)
        holder.binding.increment.setOnClickListener {
            managemntCart.plusItem(listItemSelected,position,object : ChangeNumberItemsListener{
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }

            })
        }
        holder.binding.decrement.setOnClickListener {
            managemntCart.minusItem(listItemSelected,position,object : ChangeNumberItemsListener{
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }

            })
        }
    }
}