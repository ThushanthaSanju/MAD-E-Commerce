package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.SellerDBHelper;

public class sellersigninForm extends AppCompatActivity {

    EditText id_sellerusernameenter,id_sellerpasswordenter;
    Button id_sellersigninenter;
    SellerDBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellersignin_form);

        id_sellerusernameenter = findViewById(R.id.id_sellerusernameenter);
        id_sellerpasswordenter = findViewById(R.id.id_sellerpasswordenter);
        id_sellersigninenter = findViewById(R.id.id_sellersigninenter);
        db = new SellerDBHelper(this);

        id_sellersigninenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = id_sellerusernameenter.getText().toString();
                String Password = id_sellerpasswordenter.getText().toString();

                if(Username.isEmpty() || Password.isEmpty()){
                    Toast.makeText(sellersigninForm.this,"Values can't be Empty",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checksellerpass = db.CheckSellerPass(Username,Password);
                        if(checksellerpass == true){
                            Toast.makeText(sellersigninForm.this,"Log in Successful",Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(sellersigninForm.this, SellerDetails.class);
                            startActivity(i);


                        }else{
                            Toast.makeText(sellersigninForm.this,"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                        }
                }

            }



        });

    }
}