package com.example.e_commerce_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.DBHelper;

import java.util.List;

public class AdminHome extends AppCompatActivity {
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

    }

    public void viewallAdmins(View view){

        dbHelper = new DBHelper(this);
       // DBHelper dbHelper = new DBHelper(this);

        List info = dbHelper.readAll();

        String [] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Admins List");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                String userName = infoArray[i].split(":")[0];
                String email = infoArray[i].split(":")[1];
                Toast.makeText(AdminHome.this, userName, Toast.LENGTH_SHORT).show();

                Intent j = new Intent(AdminHome.this, AdminDetails.class);
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