package com.example.e_commerce_mad.Database;

import android.provider.BaseColumns;

public class SellerMaster {
    private SellerMaster() {
    }

    public static class Seller implements BaseColumns {
        public static final String TABLE_NAME = "Sellers";
        public static final String COLUMN_NAME_USERNAME = "sellerusername";
        public static final String COLUMN_NAME_EMAIL = "selleremail";
        public static final String COLUMN_NAME_PASSWORD = "sellerpassword";
        public static final String COLUMN_NAME_CONTACT = "sellercontact";
    }

}
