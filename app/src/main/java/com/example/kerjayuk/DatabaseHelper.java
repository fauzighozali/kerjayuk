package com.example.kerjayuk;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //insert data
    public void insertData(String namalengkap, String jeniskelamin, String alamat, String pendidikan, String kontak , byte[] image){
        SQLiteDatabase databse = getWritableDatabase();
        //query untuk memasukkan inputan ke tabel database
        String sql = "INSERT INTO lawan VALUES(NULL, ?,?,?,?,?,?)";

        SQLiteStatement statement = databse.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, namalengkap);
        statement.bindString(2, jeniskelamin);
        statement.bindString(3, alamat);
        statement.bindString(4, pendidikan);
        statement.bindString(5, kontak);
        statement.bindBlob(6, image);

        statement.executeInsert();
    }

    //update data
    public void updateData(String namalengkap, String jeniskelamin, String alamat, String pendidikan, String kontak, byte[] image, int id){
        SQLiteDatabase databse = getWritableDatabase();
        //query untuk update inputtan
        String sql = "UPDATE lawan SET timname=?, category=?, date=?, time=?, contact=?, image=?, id=?";

        SQLiteStatement statement = databse.compileStatement(sql);

        statement.bindString(1, namalengkap);
        statement.bindString(2, jeniskelamin);
        statement.bindString(3, alamat);
        statement.bindString(4, pendidikan);
        statement.bindString(5, kontak);
        statement.bindBlob(6, image);
        statement.bindDouble(7, (double)id);

        statement.execute();
        databse.close();
    }

    //delete data
    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase();
        //query untuk ngapus
        String sql = "DELETE FROM lawan WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE user(email text PRIMARY KEY, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");

    }

    //memasukkan ke database
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //cek email udah ada apa belum
    public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=?", new String[] {email});
        if (cursor.getCount()>0) return false;
        else return true;
    }

    //ngecek email sama password
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE email=? and password=?", new String[]{email, password});
        if (cursor.getCount()>0) return true;
        else return false;
    }
}
