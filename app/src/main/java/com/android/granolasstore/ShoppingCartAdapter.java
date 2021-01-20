package com.android.granolasstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingCartAdapter extends
        RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartItemViewHolder> {

    class ShoppingCartItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView shoppingCartItemView;

        final ShoppingCartAdapter mAdapter;

        public ShoppingCartItemViewHolder(
                @NonNull View itemView,
                ShoppingCartAdapter adapter) {
            super(itemView);
            this.shoppingCartItemView = itemView.findViewById(R.id.name);
            this.mAdapter = adapter;
        }
    }

    private ArrayList<String> mShoppingCart;

    private LayoutInflater mInflater;

    public ShoppingCartAdapter(Context context, ArrayList<String> shoppingCart) {
        mInflater = LayoutInflater.from(context);
        mShoppingCart = shoppingCart;
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.ShoppingCartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.shopping_cart_item, parent, false);
        return new ShoppingCartItemViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ShoppingCartItemViewHolder holder, int position) {
        String current = mShoppingCart.get(position);
        holder.shoppingCartItemView.setText(current);
    }

    @Override
    public int getItemCount() {
        return mShoppingCart.size();
    }
}
