package com.example.khowoatt.bakeryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 27/4/2560.
 */

public class DrinkTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String DRINK_TABLE = "drinkTABLE";
    public static final String COLUMN_ID_DRINK = "ID_drink";
    public static final String COLUMN_DRINK = "Name_drink";
    public static final String COLUMN_DETAIL = "Detail_drink";
    public static final String COLUMN_PICTURE = "Picture_drink";
    public static final String COLUMN_PRICE = "Price_drink";

    public DrinkTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewDrink(String strName_drink, String strDetail_drink, String strPicture_drink, String strPrice_drink){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_DRINK,strName_drink);
        objContentValues.put(COLUMN_DETAIL,strDetail_drink);
        objContentValues.put(COLUMN_PICTURE,strPicture_drink);
        objContentValues.put(COLUMN_PRICE,strPrice_drink);
        return readSqLiteDatabase.insert(DRINK_TABLE,null, objContentValues);
    }
}
