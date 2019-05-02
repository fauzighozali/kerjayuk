package com.example.kerjayuk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBProfil extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "data_inventori";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_JK = "Jenis_Kelamin";
    public static final String COLUMN_NAMA = "Nama";
    public static final String COLUMN_PENDIDIKAN = "Pendidikan";
    public static final String COLUMN_ALAMAT = "Alamat";
    public static final String COLUMN_KONTAK = "Kontak";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_JK+ " varchar(50) not null, "
            + COLUMN_NAMA+ " varchar(50) not null, "
            + COLUMN_PENDIDIKAN+ " varchar(50) not null, "
            + COLUMN_ALAMAT+ " varchar(50) not null, "
            + COLUMN_KONTAK+ " varchar(50) not null);";

    public DBProfil(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBJob.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
