package com.android.granolasstore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.granolasstore.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.fab.setOnClickListener {
//            val intent = Intent(this, ShoppingCart::class.java)
//            intent.putExtra(EXTRA_SHOPPING_CART, shoppingCart);
//            startActivity(intent);
//        }
    }

    companion object {
        const val EXTRA_SHOPPING_CART = "SHOPPING_CART"
    }
}