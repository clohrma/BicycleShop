package com.zybooks.bicycleshop.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zybooks.bicycleshop.Database.Repository;
import com.zybooks.bicycleshop.R;
import com.zybooks.bicycleshop.entities.Part;
import com.zybooks.bicycleshop.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends AppCompatActivity {

    EditText editName, editPrice;
    String name;
    double price;
    int id;
    Product product;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        editName = findViewById(R.id.productName);
        editPrice = findViewById(R.id.productPrice);

        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", 0.0);
        id = getIntent().getIntExtra("id", -1);

        editName.setText(name);
        editPrice.setText(String.valueOf(price));

        RecyclerView recyclerView = findViewById(R.id.partRecyclerView);
        repository = new Repository(getApplication());
        final PartAdapter partAdapter = new PartAdapter(this);
        recyclerView.setAdapter(partAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Part> filteredParts = new ArrayList<>();
        for(Part part : repository.getAllParts()){
            if(part.getProductID() == id) filteredParts.add(part);
        }

        Button save = findViewById(R.id.saveProduct);
        save.setOnClickListener(view -> {
            if (id == -1) {
                product = new Product(0, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                repository.insert(product);
            } else {
                product = new Product(id, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                repository.update(product);
            }
        });

        FloatingActionButton fab = findViewById(R.id.productDetailsFAB);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ProductDetails.this, PartDetails.class);
            startActivity(intent);
        });
    }
}