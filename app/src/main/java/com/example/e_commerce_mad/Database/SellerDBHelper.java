package com.example.e_commerce_mad.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import kotlin.text.UStringsKt;

public class SellerDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Sellerinfo.db";

    public SellerDBHelper(Context context) { super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+SellerMaster.Seller.TABLE_NAME + " (" +
                        SellerMaster.Seller._ID+ " INTEGER PRIMARY KEY," +
                        SellerMaster.Seller.COLUMN_NAME_USERNAME+ " TEXT,"+
                        SellerMaster.Seller.COLUMN_NAME_PASSWORD+ " TEXT,"+
                        SellerMaster.Seller.COLUMN_NAME_EMAIL+ " TEXT,"+
                        SellerMaster.Seller.COLUMN_NAME_CONTACT+ " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public long addInfo(String Username,String Password,String Email,String Contact){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SellerMaster.Seller.COLUMN_NAME_USERNAME,Username);
        values.put(SellerMaster.Seller.COLUMN_NAME_PASSWORD,Password);
        values.put(SellerMaster.Seller.COLUMN_NAME_EMAIL,Email);
        values.put(SellerMaster.Seller.COLUMN_NAME_CONTACT,Contact);

        return db.insert(SellerMaster.Seller.TABLE_NAME, null, values);
    }

    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String [] projection = {
                SellerMaster.Seller._ID,
                SellerMaster.Seller.COLUMN_NAME_USERNAME,
                SellerMaster.Seller.COLUMN_NAME_EMAIL,
                SellerMaster.Seller.COLUMN_NAME_PASSWORD,
                SellerMaster.Seller.COLUMN_NAME_CONTACT
        };
        String sortOrder = SellerMaster.Seller._ID + " DESC";
        Cursor cursor = db.query(
                SellerMaster.Seller.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        List info = new ArrayList<>();
        while (cursor.moveToNext() ){
            String Username = cursor.getString(cursor.getColumnIndexOrThrow(SellerMaster.Seller.COLUMN_NAME_USERNAME));
            String Email = cursor.getString(cursor.getColumnIndexOrThrow(SellerMaster.Seller.COLUMN_NAME_EMAIL));
            String Password = cursor.getString(cursor.getColumnIndexOrThrow(SellerMaster.Seller.COLUMN_NAME_PASSWORD));
            String Contact = cursor.getString(cursor.getColumnIndexOrThrow(SellerMaster.Seller.COLUMN_NAME_CONTACT));


            info.add(Username+":"+Email+":"+Password+":"+Contact);

        }
        cursor.close();
        return info;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean CheckSellerPass(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Sellers where sellerusername = ? and sellerpassword = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void deleteinfo(String userName) {
    }
}