package com.example.movienigth.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.movienigth.Model.ModelClient;

import java.util.ArrayList;
import java.util.List;

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
        String sql ="CREATE TABLE client(" +
                "                    id_client INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                    id INTEGER,"+
                "                    first_name TEXT," +
                "                    last_name TEXT," +
                "                    ci TEXT,"+
                "                    cellphone INTEGER," +
                "                    birthdate TEXT," +
                "                    email TEXT,"+
                "                    address TEXT,"+
                "                    latitude TEXT,"+
                "                    longitude TEXT,"+
                "                    status INTEGER)";
        db.execSQL(sql);

        /**TABLA MOVIE*/

        db.execSQL("PRAGMA foreign_key = ON");
        sql ="CREATE TABLE client(" +
                "                    id_client INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                    id INTEGER,"+
                "                    first_name TEXT," +
                "                    last_name TEXT," +
                "                    ci TEXT,"+
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
        onCreate(db);
    }

    public int addClient(ModelClient modelClient){
        ContentValues values = new ContentValues();
        values.put("id",modelClient.getId());
        values.put("first_name",modelClient.getFirst_name());
        values.put("last_name",modelClient.getLast_name());
        values.put("ci",modelClient.getCi());
        values.put("cellphone",modelClient.getCellphone());
        values.put("email",modelClient.getEmail());
        values.put("address",modelClient.getAddress());
        values.put("latitude",modelClient.getLatitude());
        values.put("longitude",modelClient.getLongitude());
        values.put("birthdate",modelClient.getBirthdate());
        values.put("status",modelClient.getStatus());
        SQLiteDatabase db =this.getWritableDatabase();
        int i =(int)db.insert("client",null,values);
        Log.i("LVVV",String.valueOf(i));
        return i;


    }

    public List<ModelClient>listClient(){

        String sql = "select * from client where status == 1";
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        List<ModelClient> modelClients =new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                int id          = Integer.parseInt(cursor.getString(0));
                String nombre   = cursor.getString(1);
                String apellido = cursor.getString(2);
                String cedula   = cursor.getString(3);
                int celular     = Integer.parseInt(cursor.getString(4));
                String email    = cursor.getString(5);
                String direccion= cursor.getString(6);
                String latitud  = cursor.getString(7);
                String longitud = cursor.getString(8);
                String fecha    = cursor.getString(9);
                int status      = Integer.parseInt(cursor.getString(10));
                modelClients.add(new ModelClient(id,nombre,apellido,cedula,celular,email,direccion,latitud,longitud,fecha,status));

            }while (cursor.moveToNext());
        }
        cursor.close();
        return modelClients;
    }

    public ModelClient serchClient(int id_client){
        String query = "SELECT * FROM client WHERE id = "+id_client;
        SQLiteDatabase db = this.getReadableDatabase();
        ModelClient client = null;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){

            int id          = Integer.parseInt(cursor.getString(1));
            String nombre   = cursor.getString(2);
            String apellido = cursor.getString(3);
            String cedula   = cursor.getString(4);
            int celular     = Integer.parseInt(cursor.getString(5));
            String email    = cursor.getString(6);
            String direccion= cursor.getString(7);
            String latitud  = cursor.getString(8);
            String longitud = cursor.getString(9);
            String fecha    = cursor.getString(10);
            int status      = Integer.parseInt(cursor.getString(11));
            client = new ModelClient(id,nombre,apellido,cedula,celular,email,direccion,latitud,longitud,fecha,status);
        }
        cursor.close();
        return client;
    }

    public ModelClient serchIdName(int idBuscado,String nombreBuscado){
        String args[] = new String[]{String.valueOf(idBuscado),nombreBuscado};
        SQLiteDatabase database =this.getReadableDatabase();
        ModelClient client = null;
        Cursor cursor = database.rawQuery("SELECT * FROM client WHERE id_client = ? or first_name = ?",args);
        if(cursor.moveToFirst()){

            int id_client   = Integer.parseInt(cursor.getString(0));
            int id          = Integer.parseInt(cursor.getString(1));
            String nombre   = cursor.getString(2);
            String apellido = cursor.getString(3);
            String cedula   = cursor.getString(4);
            int celular     = Integer.parseInt(cursor.getString(5));
            String email    = cursor.getString(6);
            String direccion= cursor.getString(7);
            String latitud  = cursor.getString(8);
            String longitud = cursor.getString(9);
            String fecha    = cursor.getString(10);
            int status      = Integer.parseInt(cursor.getString(11));
            client = new ModelClient(id_client,id,nombre,apellido,cedula,celular,email,direccion,latitud,longitud,fecha,status);

        }
        cursor.close();
        return client;
    }



    public void updateCLient(ModelClient modelClient){
        ContentValues values = new ContentValues();
        values.put("id",modelClient.getId());
        values.put("first_name",modelClient.getFirst_name());
        values.put("last_name",modelClient.getLast_name());
        values.put("ci",modelClient.getCi());
        values.put("cellphone",modelClient.getCellphone());
        values.put("email",modelClient.getEmail());
        values.put("address",modelClient.getAddress());
        values.put("latitude",modelClient.getLatitude());
        values.put("longitude",modelClient.getLongitude());
        values.put("birthdate",modelClient.getBirthdate());
        values.put("status",modelClient.getStatus());
        SQLiteDatabase database = this.getWritableDatabase();
        database.update("client",values,"id_client = ?",new String[]{String.valueOf(modelClient.getId_client())});

    }
}
