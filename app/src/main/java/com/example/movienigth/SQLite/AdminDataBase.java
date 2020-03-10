package com.example.movienigth.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AdminDataBase extends SQLiteOpenHelper {

    public AdminDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbPath = db.getPath();
        Log.d(this.getClass().getSimpleName(), "****************dbpath :" +dbPath);
        /**TABLA CLIENTE */

        db.execSQL("PRAGMA foreign_key = ON");
        String sql ="CREATE TABLE client(id_client INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                    ci VARCHAR(30),"+
                    "                    first_name VARCHAR(30)," +
                    "                    last_name VARCHAR(30)," +
                    "                    cellphone VARCHAR(30)," +
                    "                    birthdate DATE   ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
