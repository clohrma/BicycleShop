package com.zybooks.bicycleshop.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zybooks.bicycleshop.R;

public class PartDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_details);
        FloatingActionButton fab = findViewById(R.id.partDetailsFAB);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(PartDetails.this, ProductDetails.class );
                startActivity(intent);
            }
        });
    }
}