package com.android.granolasstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    private RecyclerView mShoppingCartRecyclerView;
    private ShoppingCartAdapter mShoppingCartAdapter;

    private TextView mNoItemsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mShoppingCartRecyclerView = findViewById(R.id.shopping_cart_recyclerview);
        mNoItemsText = findViewById(R.id.no_items_text);

        Intent intent = getIntent();
        ArrayList<String> shoppingCart
                = (ArrayList<String>)intent.getSerializableExtra(MainActivity.EXTRA_SHOPPING_CART);

        if (shoppingCart.size() > 0) {
            mNoItemsText.setVisibility(View.GONE);
        } else {
            mNoItemsText.setVisibility(View.VISIBLE);
        }

        mShoppingCartAdapter = new ShoppingCartAdapter(this, shoppingCart);
        mShoppingCartRecyclerView.setAdapter(mShoppingCartAdapter);
        mShoppingCartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}