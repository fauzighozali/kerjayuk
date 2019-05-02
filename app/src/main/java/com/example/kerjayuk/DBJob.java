package com.example.kerjayuk;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBJob extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "data_inventori";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PERUSAHAAN = "nama_perusahaan";
    public static final String COLUMN_PEKERJAAN = "nama_pekerjaan";
    public static final String COLUMN_PENDIDIKAN = "nama_pendidikann";
    public static final String COLUMN_LOKASI = "nama_lokasi";
    public static final String COLUMN_DURASI = "nama_durasi";
    public static final String COLUMN_KONTAK = "nama_kontak";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_PERUSAHAAN+ " varchar(50) not null, "
            + COLUMN_PEKERJAAN+ " varchar(50) not null, "
            + COLUMN_PENDIDIKAN+ " varchar(50) not null, "
            + COLUMN_LOKASI+ " varchar(50) not null, "
            + COLUMN_DURASI+ " varchar(50) not null, "
            + COLUMN_KONTAK+ " varchar(50) not null);";

    public DBJob(Context context) {
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

