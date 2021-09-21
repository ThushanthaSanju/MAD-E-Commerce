package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sellerloginForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerlogin_form);
    }

    public void goToSellersignin(View view) {
        Intent i = new Intent(sellerloginForm.this, sellersigninForm.class);
        startActivity(i);
    }

    public void goToSellersignup(View view) {
        Intent i = new Intent(sellerloginForm.this, sellersignupForm.class);
        startActivity(i);
    }
}