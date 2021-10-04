package com.example.kingship;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kingship.database.DBHandler;
import com.example.kingship.model.Category;

import java.util.ArrayList;

public class DisplayCategory extends AppCompatActivity {

    TextView tvtotal;
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;
    Button delete, add;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        recyclerView= findViewById(R.id.recyclerView);
        delete =findViewById(R.id.catbtndele);

        add = findViewById(R.id.btnads);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(DisplayCategory.this, category.class);
                startActivity(i);
            }
        });
//        tvtotal =findViewById(R.id.totalview);
        DBHandler dbHandler= new DBHandler(this);

        categories = dbHandler.getAllCategeris();

        categoryAdapter = new CategoryAdapter(categories,this);
        recyclerView.setAdapter(categoryAdapter);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);



    }
}