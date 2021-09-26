package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.DBHelper;

public class AdminSignup extends AppCompatActivity {

    EditText EnterAdminName,EnteradminEmail,AdministratorPassword,AdministratorConPassword,AdminPhoneEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);

        EnterAdminName = findViewById(R.id.EnterAdminName);
        EnteradminEmail = findViewById(R.id.EnteradminEmail);
        AdministratorPassword = findViewById(R.id.AdministratorPassword);
        AdministratorConPassword = findViewById(R.id.AdministratorConPassword);
        AdminPhoneEnter = findViewById(R.id.AdminPhoneEnter);

    }

    public void saveAdmin(View view){

        String name = EnterAdminName.getText().toString();
        String email = EnteradminEmail.getText().toString();
        String password = AdministratorPassword.getText().toString();
        String conpassword = AdministratorConPassword.getText().toString();
        String number = AdminPhoneEnter.getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if ( password.equals(conpassword) ) {

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Enter Required Fields", Toast.LENGTH_SHORT).show();
            } else {
                Long inserted = dbHelper.addinfo(name, email, password, number);

                if (inserted > 0) {
                    Toast.makeText(this, "Admin Data inserted Successfully", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(AdminSignup.this, AdminLoginform.class);
                    startActivity(i);

                } else {
                    Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();

                }
            }
        }else{
            Toast.makeText(this, "Passwords Mismatched", Toast.LENGTH_SHORT).show();
        }

    }
}