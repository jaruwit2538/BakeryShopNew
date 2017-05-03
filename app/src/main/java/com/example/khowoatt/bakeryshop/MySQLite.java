package com.example.khowoatt.bakeryshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by khowoatt on 28/4/2560.
 */

public class MySQLite extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Shop.db";//กำหนดชื่อไฟล์ Database
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "create table userTABLE1" +//สร้าง Table
            "(ID_num integer primary key, Username text, Password text, Phone text, Address text, Email text, Facebook text);";
    private static final String CREATE_BAKERY_TABLE = "create table bakeryTABLE" +
            "(ID_bakery integer primary key, Name_bakery text, Detail_bakery text, Picture_bakery text,Price_bakery text);";
    private static final String CREATE_ORDER_TABLE = "create table orderTABLE" +
            "(ID_order integer primary key, Date text ,Number text, Total_price text);";
    private static final String CREATE_DRINK_TABLE = "create table drinkTABLE" +
            "(ID_drink integer primary key, Name_drink text, Detail_drink text, Picture_drink text,Price_drink text);";
    private static final String CREATE_CAKE_TABLE = "create table cakeTABLE" +
            "(ID_cake integer primary key, Name_cake text, Detail_cake text, Picture_cake text,Price_cake text);";


    public MySQLite(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_BAKERY_TABLE);
        sqLiteDatabase.execSQL(CREATE_ORDER_TABLE);
        sqLiteDatabase.execSQL(CREATE_DRINK_TABLE);
        sqLiteDatabase.execSQL(CREATE_CAKE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int l) {

    }
}
