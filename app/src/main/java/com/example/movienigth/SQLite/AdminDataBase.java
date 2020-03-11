package com.example.movienigth.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.movienigth.Model.ModelClient;

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
                    "                    ci TEXT,"+
                    "                    first_name TEXT," +
                    "                    last_name TEXT," +
                    "                    cellphone INTEGER," +
                    "                    birthdate TEXT," +
                    "                    email TEXT,"+
                    "                    address TEXT,"+
                    "                    latitude TEXT,"+
                    "                    longitude TEXT,"+
                    "                    status INTEGER)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS client");
    }

    public void addClient(ModelClient modelClient){
        ContentValues values = new ContentValues();
        values.put("id_client",modelClient.getId_client());
        values.put("ci",modelClient.getCi());
        values.put("first_name",modelClient.getFirst_name());
        values.put("last_name",modelClient.getLast_name());
        values.put("cellphone",modelClient.getCellphone());
        values.put("birthdate",modelClient.getBirthdate());
        values.put("email",modelClient.getEmail());
        values.put("address",modelClient.getAddress());
        values.put("latitude",modelClient.getLatitude());
        values.put("longitude",modelClient.getLongitude());
        values.put("status",modelClient.getStatus());
    }
}
