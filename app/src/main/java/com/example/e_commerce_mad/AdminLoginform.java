package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.DBHelper;

public class AdminLoginform extends AppCompatActivity {

    EditText AdminUserName,AdminPass;
    Button AdminLoginButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_loginform);

        AdminUserName = findViewById(R.id.AdminUserName);
        AdminPass = findViewById(R.id.AdminPass);
        AdminLoginButton = findViewById(R.id.AdminLoginButton);
        DB = new DBHelper(this);

        AdminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = AdminUserName.getText().toString();
                String Password = AdminPass.getText().toString();

                if (username.isEmpty() || Password.isEmpty() ) {
                    Toast.makeText(AdminLoginform.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.CheckUserPass(username,Password);
                    if (checkuserpass == true){
                        Toast.makeText(AdminLoginform.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(AdminLoginform.this, AdminHome.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(AdminLoginform.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }
}