package com.example.e_commerce_mad.Database;

import android.provider.BaseColumns;

public class AdminMaster {
    private  AdminMaster(){}

    public static class Admin implements BaseColumns{
        public static final String TABLE_NAME = "Admins";
        public static final String COLUMN_NAME_USERNAME = "adminusername";
        public static final String COLUMN_NAME_EMAIL = "adminemail";
        public static final String COLUMN_NAME_PASSWORD = "adminpassword";
        public static final String COLUMN_NAME_CONTACT = "admincontact";
    }
}

