package com.example.uaspwpb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSiswa extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UserInfo";
    private static final String TABLE_NAME = "tbl_uas";
    private static final String KEY_JUDUL = "judul";
    private static final String KEY_DESKRIPSI = "deskripsi";

    public DatabaseSiswa(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable = "Create Table "+TABLE_NAME+"("+KEY_JUDUL+" TEXT,"+KEY_DESKRIPSI+" TEXT)";
        sqLiteDatabase.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "Drop Table If Exists "+TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public List<Siswa> selectUserData(){
        ArrayList<Siswa> userList = new ArrayList<Siswa>();

        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {KEY_JUDUL,KEY_DESKRIPSI};

        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while(c.moveToNext()){
            String judul = c.getString(0);
            String deskripsi = c.getString(1);

            Siswa s = new Siswa();
            s.setJudul(judul);
            s.setDeskripsi(deskripsi);
            userList.add(s);
        }

        return userList;
    }

//    public void update(Siswa siswa){
//        SQLiteDatabase db = getReadableDatabase();
//        ContentValues val = new ContentValues();
//        val.put(KEY_NAME,siswa.getNama());
//        val.put(KEY_BIRTHDAY,siswa.getTanggalLahir());
//        val.put(KEY_JENKEL,siswa.getJenisKelamin());
//        val.put(KEY_ALAMAT,siswa.getAlamat());
//        String whereClause = KEY_NIS+"='"+siswa.getNis()+"'";
//        db.update(TABLE_NAME,val,whereClause,null);
//    }

    public void insert(Siswa siswa){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(KEY_JUDUL,siswa.getJudul());
        val.put(KEY_DESKRIPSI,siswa.getDeskripsi());

        db.insert(TABLE_NAME,null,val);
    }

//    public void delete(String nis){
//        SQLiteDatabase db = getWritableDatabase();
//        String whereClause = KEY_NIS+"='"+nis+"'";
//        db.delete(TABLE_NAME,whereClause,null);
//    }
}
