package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class userLogview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logview);
    }

    public void goToCusSignUp(View view) {
        Intent i = new Intent(userLogview.this, cusSignup.class);
        startActivity(i);
    }
    public void goToCusSignIn(View view) {
        Intent i = new Intent(userLogview.this, cusSignin.class);
        startActivity(i);
    }
}