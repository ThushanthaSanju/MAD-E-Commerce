package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.SellerDBHelper;

public class SellerDetails extends AppCompatActivity {

    EditText id_sellerUser, id_sellerEmail, id_sellpassview, id_sellcontview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_details);

        Intent intent = getIntent();

        String Username = intent.getStringExtra("Username");
        String Email = intent.getStringExtra("Email");
        String Password = intent.getStringExtra("Password");
        String Contact = intent.getStringExtra("Contact");

        EditText textView = (EditText) findViewById(R.id.id_sellerUser);
        textView.setText(Username);
        EditText textView1 = (EditText) findViewById(R.id.id_sellerEmail);
        textView1.setText(Email);
        EditText textView2 = (EditText) findViewById(R.id.id_sellpassview);
        textView2.setText(Password);
        EditText textView3 = (EditText) findViewById(R.id.id_sellcontview);
        textView3.setText(Contact);

    }


    public void DeleteSeller(View view) {
        SellerDBHelper db = new SellerDBHelper(this);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("uname");
        String userName = fName;


        if (userName.isEmpty()) {
            Toast.makeText(SellerDetails.this, "Select a Seller", Toast.LENGTH_SHORT).show();
        } else {
            db.deleteinfo(userName);
            Toast.makeText(SellerDetails.this, userName + "Deleted a Seller", Toast.LENGTH_SHORT).show();

        }

    }
}


