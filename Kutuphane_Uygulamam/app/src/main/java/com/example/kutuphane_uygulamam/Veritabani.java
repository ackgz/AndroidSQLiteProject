package com.example.kutuphane_uygulamam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;


public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Kutuphane_Uygulamam";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_KITAPLAR = "Kitaplar";
    private static final String ROW_ID = "id";
    private static final String ROW_KITAP_AD = "ad";
    private static final String ROW_YAZAR = "soyad";
    private static final String ROW_STOK = "tel";


    public Veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_KITAPLAR + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_KITAP_AD + " TEXT NOT NULL, "
                + ROW_YAZAR + " TEXT NOT NULL, "
                + ROW_STOK + " TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_KITAPLAR);
        onCreate(db);

    }

    public void VeriEkle(String ad, String soyad, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_KITAP_AD, ad);
            cv.put(ROW_YAZAR, soyad);
            cv.put(ROW_STOK, tel);
            db.insert(TABLO_KITAPLAR, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_KITAP_AD,ROW_YAZAR,ROW_STOK};
            Cursor cursor = db.query(TABLO_KITAPLAR, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3));
            }
        }catch (Exception e){
        }
        db.close();
        return veriler;
    }

    public void VeriSil(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String where = ROW_ID + " = " + id ;
            db.delete(TABLO_KITAPLAR,where,null);
        }catch (Exception e){
        }
        db.close();
    }

    public void VeriDuzenle(int id, String ad, String soyad, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_KITAP_AD, ad);
            cv.put(ROW_YAZAR, soyad);
            cv.put(ROW_STOK, tel);
            String where = ROW_ID +" = '"+ id + "'";
            db.update(TABLO_KITAPLAR,cv,where,null);
        }catch (Exception e){
        }
        db.close();
    }
}