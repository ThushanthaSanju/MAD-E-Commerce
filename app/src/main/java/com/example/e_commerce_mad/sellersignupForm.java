package com.example.e_commerce_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce_mad.Database.DBHelper;
import com.example.e_commerce_mad.Database.SellerDBHelper;

public class sellersignupForm extends AppCompatActivity {

    EditText id_sellerusernameent,id_selleremailent,id_sellerpasswordoneent,id_sellerpasswordtwoent,id_sellercontactnument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellersignup_form);
        id_sellerusernameent = findViewById(R.id.id_sellerusernameent);
        id_selleremailent = findViewById(R.id.id_selleremailent);
        id_sellerpasswordoneent = findViewById(R.id.id_sellerpasswordoneent);
        id_sellerpasswordtwoent = findViewById(R.id.id_sellerpasswordtwoent);
        id_sellercontactnument = findViewById(R.id.id_sellercontactnument);
    }



    public void saveSeller(View view){

        String Username = id_sellerusernameent.getText().toString();
        String Password = id_sellerpasswordoneent.getText().toString();
        String Email = id_selleremailent.getText().toString();
        String Contact = id_sellercontactnument.getText().toString();
        SellerDBHelper dbHelper = new SellerDBHelper(this);

        if(Username.isEmpty()||Password.isEmpty()||Email.isEmpty()||Contact.isEmpty()){
            Toast.makeText(this,"Enter All Values",Toast.LENGTH_SHORT).show();
        }else{
            long inserted = dbHelper.addInfo(Username,Password,Email,Contact);

            if(inserted>0){
                Toast.makeText(this,"Entered Successfully",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Attempt Unsuccessful",Toast.LENGTH_SHORT).show();
            }
        }

    }
}