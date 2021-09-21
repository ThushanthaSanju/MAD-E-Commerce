package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToAnActivity(View view) {
        Intent i = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(i);
    }
    public void goToUserLogView(View view) {
        Intent i = new Intent(MainActivity.this, userLogview.class);
        startActivity(i);
    }

    public void goToSellerlogView(View view) {
        Intent i = new Intent(MainActivity.this, sellerloginForm.class);
        startActivity(i);
    }
}