package com.example.e_commerce_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.SellerDBHelper;

import java.util.List;

public class SellerHome extends AppCompatActivity {
    SellerDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

    }

    public void viewallSellers(View view) {

        dbHelper = new SellerDBHelper(this);
        // DBHelper dbHelper = new DBHelper(this);

        List info = dbHelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sellers List");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                String userName = infoArray[i].split(":")[0];
                String email = infoArray[i].split(":")[1];
                Toast.makeText(SellerHome.this, userName, Toast.LENGTH_SHORT).show();

                Intent j = new Intent(SellerHome.this, SellerDetails.class);
                j.putExtra("uname", userName);
                j.putExtra("email", email);
                startActivity(j);


            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}