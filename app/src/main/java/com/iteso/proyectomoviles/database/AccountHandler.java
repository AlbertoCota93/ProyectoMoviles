package com.iteso.proyectomoviles.database;

import android.accounts.Account;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class AccountHandler {

    public void addAccount (String account,String game , DatabaseHandler databaseHandler){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandler.ACCOUNT_GAME, game);
        contentValues.put(DatabaseHandler.ACCOUNT_NAME,account);

    }
}
