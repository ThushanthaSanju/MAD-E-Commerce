package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }

    public void AdminLogin(View view) {
        Intent i = new Intent(AdminLogin.this, AdminLoginform.class);
        startActivity(i);
    }
    public void AdminSignup(View view) {
        Intent i = new Intent(AdminLogin.this, AdminLoginform.class);
        startActivity(i);
    }
}