package com.android.granolasstore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.granolasstore.ShoppingCartAdapter.ShoppingCartItemViewHolder
import java.util.*

class ShoppingCartAdapter(context: Context?, shoppingCart: Array<String>) : RecyclerView.Adapter<ShoppingCartItemViewHolder>() {

    inner class ShoppingCartItemViewHolder(
            itemView: View,
            adapter: ShoppingCartAdapter) : RecyclerView.ViewHolder(itemView) {

        val shoppingCartItemView: TextView = itemView.findViewById(R.id.name)
        val mAdapter: ShoppingCartAdapter = adapter

    }

    private val shoppingCart: Array<String> = shoppingCart
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartItemViewHolder {
        val itemView = inflater.inflate(R.layout.shopping_cart_item, parent, false)
        return ShoppingCartItemViewHolder(itemView, this)
    }

    override fun onBindViewHolder(holder: ShoppingCartItemViewHolder, position: Int) {
        val current = shoppingCart[position]
        holder.shoppingCartItemView.text = current
    }

    override fun getItemCount(): Int {
        return shoppingCart.size
    }

}