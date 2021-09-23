package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AdminDetails extends AppCompatActivity {

    EditText AdminUSERNAME,adminEMAIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details);

        Intent intent = getIntent();


        String fName = intent.getStringExtra("uname");
        String lName = intent.getStringExtra("email");


        EditText textView = (EditText) findViewById(R.id.AdminUSERNAME);
        textView.setText(fName);
        EditText textView1 = (EditText) findViewById(R.id.adminEMAIL);
        textView1.setText(lName);

    }
}