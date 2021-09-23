package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.DBHelper;

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

    public void DeleteUSer(View view){
        DBHelper db =new DBHelper(this);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("uname");
        String userName =fName;

        // String userName = AdminUSERNAME.getText().toString();

         if (userName.isEmpty()){
             Toast.makeText(AdminDetails.this, "Select a Admin", Toast.LENGTH_SHORT).show();
         }else{
             db.deleteinfo(userName);
             Toast.makeText(AdminDetails.this, userName+"Deleted a Admin", Toast.LENGTH_SHORT).show();

         }

    }

    public void updateInfo(View view){
        DBHelper db =new DBHelper(this);
        AdminUSERNAME = findViewById(R.id.AdminUSERNAME);
        adminEMAIL = findViewById(R.id.adminEMAIL);


        String userName = AdminUSERNAME.getText().toString();
        String email= adminEMAIL.getText().toString();

        if (userName.isEmpty()||email.isEmpty()){
            Toast.makeText(AdminDetails.this, "Select a Admin", Toast.LENGTH_SHORT).show();

        }else{
            db.updateInfo(view,userName,email);
        }

    }
}












