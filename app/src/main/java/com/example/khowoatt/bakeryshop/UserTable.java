package com.example.khowoatt.bakeryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 21/4/2560.
 */

public class UserTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String USER_TABLE = "userTABLE";
    public static final String COLUMN_ID_USER = "ID_num";
    public static final String COLUMN_USER = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_PHONE = "Phone";
    public static final String COLUMN_EMAIL = "Email";


    public UserTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewUser(String strUsername, String strPassword, String strPhone,String strEmail){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUsername);
        objContentValues.put(COLUMN_PASSWORD,strPassword);
        objContentValues.put(COLUMN_PHONE,strPhone);
        objContentValues.put(COLUMN_EMAIL,strEmail);
        return readSqLiteDatabase.insert(USER_TABLE,null, objContentValues);
    }


}