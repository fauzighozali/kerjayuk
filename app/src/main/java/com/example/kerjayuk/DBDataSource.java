package com.example.kerjayuk;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBDataSource {

    private SQLiteDatabase database;

    private DBJob dbJob;
    private DBProfil dbProfil;

    private String[] allColumns = { DBJob.COLUMN_ID, DBJob.COLUMN_PERUSAHAAN, DBJob.COLUMN_PEKERJAAN,DBJob.COLUMN_PENDIDIKAN,DBJob.COLUMN_LOKASI,DBJob.COLUMN_DURASI,DBJob.COLUMN_KONTAK};
    private String[] getAllColumns= {DBProfil.COLUMN_ID,DBProfil.COLUMN_NAMA,DBProfil.COLUMN_JK,DBProfil.COLUMN_PENDIDIKAN,DBProfil.COLUMN_ALAMAT,DBProfil.COLUMN_KONTAK};

    public DBDataSource(Context context) {
        dbJob = new DBJob(context);
        dbProfil = new DBProfil(context);
    }


    public void open() throws SQLException {
        database = dbJob.getWritableDatabase();
        database = dbProfil.getWritableDatabase();
    }

    public void close() {
        dbJob.close();
        dbProfil.close();
    }

    public Pekerjaan createPekerjaan(String iperusahaan, String ipekerjaan, String ipendidikan, String ilokasi, String idurasi, String ikontak) {

        ContentValues values = new ContentValues();
        values.put(DBJob.COLUMN_PERUSAHAAN, iperusahaan);
        values.put(DBJob.COLUMN_PEKERJAAN, ipekerjaan);
        values.put(DBJob.COLUMN_PENDIDIKAN, ipendidikan);
        values.put(DBJob.COLUMN_LOKASI, ilokasi);
        values.put(DBJob.COLUMN_DURASI, idurasi);
        values.put(DBJob.COLUMN_KONTAK, ikontak);

        long insertId = database.insert(DBJob.TABLE_NAME, null,
                values);

        Cursor cursor = database.query(DBJob.TABLE_NAME,
                allColumns, DBJob.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Pekerjaan newPekerjaan = cursorToPekerjaan(cursor);
        cursor.close();
        return newPekerjaan;
    }

    private Pekerjaan cursorToPekerjaan(Cursor cursor) {

        Pekerjaan pekerjaan = new Pekerjaan();

        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        pekerjaan.setId(cursor.getLong(0));
        pekerjaan.setNamaperusahaan(cursor.getString(1));
        pekerjaan.setNamapekerjaan(cursor.getString(2));
        pekerjaan.setNamapendidikan(cursor.getString(3));
        pekerjaan.setNamalokasi(cursor.getString(4));
        pekerjaan.setNamadurasi(cursor.getString(5));
        pekerjaan.setNamakontak(cursor.getString(6));

        return pekerjaan;
    }


    public ArrayList<Pekerjaan> getAllPekerjaan() {
        ArrayList<Pekerjaan> daftarPekerjaan = new ArrayList<Pekerjaan>();

        Cursor cursor = database.query(DBJob.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Pekerjaan pekerjaan = cursorToPekerjaan(cursor);
            daftarPekerjaan.add(pekerjaan);
            cursor.moveToNext();
        }

        cursor.close();
        return daftarPekerjaan;
    }


    public Pekerjaan getPekerjaan(long id) {
        Pekerjaan pekerjaan = new Pekerjaan();
        Cursor cursor = database.query(DBJob.TABLE_NAME, allColumns, "_id ="+id, null, null, null, null);

        cursor.moveToFirst();
        pekerjaan = cursorToPekerjaan(cursor);
        cursor.close();
        return pekerjaan;
    }

    public void updatePekerjaan(Pekerjaan p) {
        String strFilter = "_id=" + p.getId();
        ContentValues args = new ContentValues();
        args.put(DBJob.COLUMN_PERUSAHAAN, p.getNamaperusahaan());
        args.put(DBJob.COLUMN_PEKERJAAN, p.getNamapekerjaan());
        args.put(DBJob.COLUMN_PENDIDIKAN, p.getNamapendidikan());
        args.put(DBJob.COLUMN_LOKASI, p.getNamalokasi());
        args.put(DBJob.COLUMN_DURASI, p.getNamadurasi());
        args.put(DBJob.COLUMN_KONTAK, p.getNamakontak() );
        database.update(DBJob.TABLE_NAME, args, strFilter, null);
    }

    public void deletePekerjaan(long id) {
        String strFilter = "_id=" + id;
        database.delete(DBJob.TABLE_NAME, strFilter, null);

    }

    public Profil createProfil(String inama, String ijk, String ipendidikan, String ialamat, String ikontak) {

        ContentValues values = new ContentValues();
        values.put(DBProfil.COLUMN_NAMA, inama);
        values.put(DBProfil.COLUMN_JK, ijk);
        values.put(DBProfil.COLUMN_PENDIDIKAN, ipendidikan);
        values.put(DBProfil.COLUMN_ALAMAT, ialamat);
        values.put(DBProfil.COLUMN_KONTAK, ikontak);

        long insertId = database.insert(DBProfil.TABLE_NAME, null,
                values);

        Cursor cursor = database.query(DBProfil.TABLE_NAME,
                allColumns, DBProfil.COLUMN_ID + " = " + insertId, null,
                null, null, null);


        cursor.moveToFirst();
        Profil newProfil = cursorToProfil(cursor);
        cursor.close();
        return newProfil;
    }

    private Profil cursorToProfil(Cursor cursor) {

        Profil profil = new Profil();

        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        profil.setId(cursor.getLong(0));
        profil.setNamanama(cursor.getString(1));
        profil.setNamajk(cursor.getString(2));
        profil.setNamapendidikan(cursor.getString(3));
        profil.setNamaalamat(cursor.getString(4));
        profil.setNamakontak(cursor.getString(5));

        return profil;
    }

    public ArrayList<Profil> getAllProfil() {
        ArrayList<Profil> daftarProfil = new ArrayList<Profil>();

        Cursor cursor = database.query(DBProfil.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Profil profil = cursorToProfil(cursor);
            daftarProfil.add(profil);
            cursor.moveToNext();
        }

        cursor.close();
        return daftarProfil;
    }


    public Profil getProfil(long id) {
        Profil profil = new Profil();
        Cursor cursor = database.query(DBProfil.TABLE_NAME, allColumns, "_id ="+id, null, null, null, null);

        cursor.moveToFirst();
        profil = cursorToProfil(cursor);
        cursor.close();
        return profil;
    }

    public void updateProfil(Profil p) {
        String strFilter = "_id=" + p.getId();
        ContentValues args = new ContentValues();
        args.put(DBProfil.COLUMN_NAMA, p.getNamanama());
        args.put(DBProfil.COLUMN_JK, p.getNamajk());
        args.put(DBProfil.COLUMN_PENDIDIKAN, p.getNamapendidikan());
        args.put(DBProfil.COLUMN_ALAMAT, p.getNamaalamat());
        args.put(DBProfil.COLUMN_KONTAK, p.getNamakontak() );
        database.update(DBProfil.TABLE_NAME, args, strFilter, null);
    }

    public void deleteProfil(long id) {
        String strFilter = "_id=" + id;
        database.delete(DBProfil.TABLE_NAME, strFilter, null);
    }
}
