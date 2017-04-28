package com.example.khowoatt.bakeryshop;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by khowoatt on 21/4/2560.
 */

public class OrderTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String ORDER_TABLE = "orderTable";
    public static final String COLUMN_ID_ORDER = "ID_order";
    public static final String COLUMN_NUNBER = "Number";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_TOTALPRICE = "Total_Price";
    public static final String COLUMN_PRICE = "price";

    public OrderTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewOrder(String strprice,String strNumber, String strDate, String strTotalPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_NUNBER,strNumber);
        objContentValues.put(COLUMN_DATE,strDate);
        objContentValues.put(COLUMN_TOTALPRICE,strTotalPrice);
        objContentValues.put(COLUMN_PRICE,strprice);
        return writeSqLiteDatabase.insert(ORDER_TABLE,null, objContentValues);
    }
}