package com.example.khowoatt.bakeryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 28/4/2560.
 */

public class BakeryTable {private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String BAKERY_TABLE = "bakeryTable";
    public static final String COLUMN_ID_BAKERY = "ID_bakery";
    public static final String COLUMN_BAKERY = "Name_bakery";
    public static final String COLUMN_SOURCE = "Detail_bakery";
    public static final String COLUMN_PRICE = "Picture_bakery";

    public BakeryTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewBakery(String strName_bakery, String strDetail_bakery, String strPicture_bakery){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_BAKERY,strName_bakery);
        objContentValues.put(COLUMN_SOURCE,strDetail_bakery);
        objContentValues.put(COLUMN_PRICE,strPicture_bakery);

        return writeSqLiteDatabase.insert(BAKERY_TABLE,null, objContentValues);
    }

}
