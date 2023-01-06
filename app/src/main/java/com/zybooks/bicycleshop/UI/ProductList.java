package com.zybooks.bicycleshop.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zybooks.bicycleshop.Database.Repository;
import com.zybooks.bicycleshop.R;
import com.zybooks.bicycleshop.entities.Product;

import java.util.List;

public class ProductList extends AppCompatActivity {
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ProductList.this, ProductDetails.class );
                startActivity(intent);
            }
        });
        repository=new Repository(getApplication());
        List<Product> allProducts = repository.getAllProducts();
        RecyclerView recyclerView = findViewById(R.id.productRecyclerview);

        final ProductAdapter productAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter.setProducts(allProducts);
    }

    @Override
    public void onResume() {

        super.onResume();
        List<Product> allProducts = repository.getAllProducts();
        RecyclerView recyclerView = findViewById(R.id.productRecyclerview);
        final ProductAdapter productAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter.setProducts(allProducts);
    }
}