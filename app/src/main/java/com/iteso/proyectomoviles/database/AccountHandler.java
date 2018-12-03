package com.iteso.proyectomoviles.database;

import android.accounts.Account;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AccountHandler {

    public void addAccount (String account,String game , DatabaseHandler databaseHandler){
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandler.ACCOUNT_GAME, game);
        contentValues.put(DatabaseHandler.ACCOUNT_NAME,account);

    }

    public ArrayList<String> getAccount(DatabaseHandler dh){
        ArrayList<String> accounts = new ArrayList<>();

        SQLiteDatabase db = dh.getReadableDatabase();

        String select = "SELECT " + DatabaseHandler.ACCOUNT_NAME +
                        " FROM " + DatabaseHandler.TABLE_ACCOUNTS;
        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            accounts.add(select);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e){

        }
         return accounts;
    }
}
