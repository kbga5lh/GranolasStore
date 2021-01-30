package com.android.granolasstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.android.granolasstore.databinding.FragmentGranolasListBinding
import com.android.granolasstore.databinding.FragmentShoppingCartBinding
import java.util.ArrayList

class GranolasList : Fragment() {

    private var shoppingCart = arrayOf<String>()

    private var _binding: FragmentGranolasListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentGranolasListBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.caramelCakeBuyButton.setOnClickListener {
            shoppingCart = shoppingCart.plus("Карамельный Торт")
        }
        binding.berryMixBuyButton.setOnClickListener {
            shoppingCart = shoppingCart.plus("Ягодное Поле")
        }
        binding.spicyMixBuyButton.setOnClickListener {
            shoppingCart = shoppingCart.plus("Пряное Торжество")
        }

        binding.jumpToShoppingCart.setOnClickListener {
            val action = GranolasListDirections.actionGranolasListToShoppingCart(shoppingCart = shoppingCart)
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}