package com.iteso.proyectomoviles.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ItesoStore.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHandler dataBaseHandler;

    //TABLES
    public static final String TABLE_ACCOUNTS = "Accounts";

    //Columns
    public static final String ACCOUNT_ID = "Id";
    public static final String ACCOUNT_NAME = "Name";
    public static final String ACCOUNT_GAME = "Game";

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHandler getInstance(Context context) {
        if(dataBaseHandler == null) {
            dataBaseHandler = new DatabaseHandler(context);

            Log.e("Stores", " GetInstance True", null);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.e("Stores", " OnCreate", null);
        String tableAccount = "CREATE TABLE " + TABLE_ACCOUNTS + " ("
                + ACCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + ACCOUNT_GAME + " TEXT,"
                + ACCOUNT_NAME + " TEXT)";

        db.execSQL(tableAccount);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        /*switch (oldVersion) {
            case 1:
                default:
        }
        */
    }
}

