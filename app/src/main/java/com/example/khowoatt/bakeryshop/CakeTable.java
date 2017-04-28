package com.example.khowoatt.bakeryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 27/4/2560.
 */

public class CakeTable { private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String CAKE_TABLE = "cakeTable";
    public static final String COLUMN_ID_CAKE = "ID_cake";
    public static final String COLUMN_CAKE = "Name_cake";
    public static final String COLUMN_SOURCE = "Detail_cake";
    public static final String COLUMN_PRICE = "Picture_cake";

    public CakeTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewCake(String strName_cake, String strDetail_cake, String strPicture_cake){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_CAKE,strName_cake);
        objContentValues.put(COLUMN_SOURCE,strDetail_cake);
        objContentValues.put(COLUMN_PRICE,strPicture_cake);
        return readSqLiteDatabase.insert(CAKE_TABLE,null, objContentValues);
    }
}
