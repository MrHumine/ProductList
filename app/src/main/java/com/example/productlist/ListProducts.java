package com.example.productlist;


import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

class ListProducts {
    private ArrayList<Products> product;

    ListProducts() {
        product = new ArrayList<>();
    }

    void add(Products products) {product.add(products);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result;

        result = new StringBuilder();

        for (Products p : product) {
            result.append(p.getProduct()).append("\n").append(p.getQuantity());
        }
        return result.toString();
    }
}