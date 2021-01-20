package com.android.granolasstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SHOPPING_CART
            = "SHOPPING_CART";

    private ArrayList<String> mShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShoppingCart = new ArrayList<String>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                intent.putExtra(EXTRA_SHOPPING_CART, mShoppingCart);
                startActivity(intent);
            }
        });
    }

    public void showIceCreamOrder(View view) {
        mShoppingCart.add("Ice Cream");
        displayToast(view, getString(R.string.ice_cream_order_message));
    }

    public void displayToast(View view, String message) {
        Snackbar.make(view, message,
                Snackbar.LENGTH_SHORT).show();
    }
}