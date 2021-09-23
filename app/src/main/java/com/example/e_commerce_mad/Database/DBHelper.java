package com.example.e_commerce_mad.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AdminINfo.db";


    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AdminMaster.Admin.TABLE_NAME + " (" + AdminMaster.Admin._ID +
                    " INTEGER PRIMARY KEY," +
                    AdminMaster.Admin.COLUMN_NAME_USERNAME + " TEXT," +
                    AdminMaster.Admin.COLUMN_NAME_EMAIL + " TEXT," +
                    AdminMaster.Admin.COLUMN_NAME_PASSWORD + " TEXT," +
                    AdminMaster.Admin.COLUMN_NAME_CONTACT + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    public Long addinfo(String username,String email,String password,String contact){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AdminMaster.Admin.COLUMN_NAME_USERNAME, username);
        values.put(AdminMaster.Admin.COLUMN_NAME_EMAIL, email);
        values.put(AdminMaster.Admin.COLUMN_NAME_PASSWORD, password);
        values.put(AdminMaster.Admin.COLUMN_NAME_CONTACT, contact);

        return db.insert(AdminMaster.Admin.TABLE_NAME,null,values);
    }

    public boolean CheckUserPass(String username,String Password){
        SQLiteDatabase DB = getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Admins where adminusername = ? and adminpassword = ?", new String[] {username,Password});
        if (cursor.getCount()>0){
            return true;
        }else
            return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
