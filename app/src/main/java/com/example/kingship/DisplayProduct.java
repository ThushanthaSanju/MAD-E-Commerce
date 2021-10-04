package com.example.kingship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.kingship.database.DBHandler;
import com.example.kingship.model.Product;

import java.util.ArrayList;

public class DisplayProduct extends AppCompatActivity {

    TextView total;
    // EditText brdname;
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    ArrayList<Product> products;

    Button delete;
    Button nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        recyclerView = findViewById(R.id.recyclerView);
        delete =findViewById(R.id.cardDelete);
        nav = findViewById(R.id.btnp);

        //brdname =findViewById(R.id.Braname);
        // total =findViewById(R.id.totalview);

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ProductInsert.class);
                startActivity(i);
            }
        });

        DBHandler dbHandler= new DBHandler(this);
        products =dbHandler.getAllProduct();

        productAdapter = new ProductAdapter(products,this);
        recyclerView.setAdapter(productAdapter);

        LinearLayoutManager llms= new LinearLayoutManager(this);
        llms.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llms);


    }
}