package com.example.khowoatt.bakeryshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 28/4/2560.
 */

public class BakeryTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase,readSqLiteDatabase;

    public static final String BAKERY_TABLE = "bakeryTABLE";
    public static final String COLUMN_ID_BAKERY = "ID_bakery";
    public static final String COLUMN_BAKERY = "Name_bakery";
    public static final String COLUMN_DETAIL = "Detail_bakery";
    public static final String COLUMN_PICTURE = "Picture_bakery";
    public static final String COLUMN_PRICE = "Price_bakery";

    public BakeryTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }
    public long addNewBakery(String strName_bakery, String strDetail_bakery, String strPicture_bakery ,String strPrice_bakery){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_BAKERY,strName_bakery);
        objContentValues.put(COLUMN_DETAIL,strDetail_bakery);
        objContentValues.put(COLUMN_PICTURE,strPicture_bakery);
        objContentValues.put(COLUMN_PRICE,strPrice_bakery);

        return readSqLiteDatabase.insert(BAKERY_TABLE,null, objContentValues);
    }
    public String[] readAllBakery(int intColumn) {
        String[] strReadALL = null;
        Cursor objCursor = readSqLiteDatabase.query(BAKERY_TABLE,
                new String[]{COLUMN_BAKERY,COLUMN_DETAIL,COLUMN_PICTURE,COLUMN_PRICE},null,null,null,null,null);
        if (objCursor != null) {
            objCursor.moveToFirst();
            strReadALL = new String[objCursor.getCount()];
            for (int i = 0; i <= objCursor.getCount();i++) {
                switch (intColumn) {
                    case 1:
                        strReadALL[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BAKERY));
                        break;
                    case 2:
                        strReadALL[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_DETAIL));
                        break;
                    case 3:
                        strReadALL[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PICTURE));
                        break;
                    default:
                        strReadALL[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_PRICE));
                        break;
                }
                objCursor.moveToNext();
            }
        }
        return strReadALL;
    }

}
