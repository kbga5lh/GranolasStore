package com.android.granolasstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.granolasstore.databinding.FragmentShoppingCartBinding
import java.util.ArrayList

class ShoppingCart : Fragment() {

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding!!

    var a: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            a = it.getStringArray("shoppingCart")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)

        if (a != null) {
            val shoppingCartAdapter = ShoppingCartAdapter(context, a!!)
            binding.shoppingCartRecyclerview.adapter = shoppingCartAdapter
            binding.shoppingCartRecyclerview.layoutManager = LinearLayoutManager(context)
        } else {
            Toast.makeText(context, "f", Toast.LENGTH_SHORT).show()
        }

        return binding.root

//        val intent = intent
//        val shoppingCart = intent.getSerializableExtra(MainActivity.EXTRA_SHOPPING_CART) as ArrayList<String>
//
//        if (shoppingCart.size > 0) {
//            binding.noItemsText.visibility = View.GONE
//        } else {
//            binding.noItemsText.visibility = View.VISIBLE
//        }
//
    }
}