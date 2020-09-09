package com.example.helpdroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db_adapter {

    static final String db_name = "contactsdb";
    static final int db_ver = 1;
    static final String tb_name = "contactinfo";
    static final String no_db = "no";
    static final String name_db = "name";
    static final String index = "_id";
    static final String qq = "create table " +
            tb_name + " (" +
            index + " Integer primary key autoincrement ," +
            name_db + " varchar2 not null," +
            no_db + " varchar2 not null);";

    static private SQLiteDatabase sqdb;
    private dbhelper dbh;
    private Context c;

    public db_adapter(Context c) {
        this.c = c;
        dbh = new dbhelper(c, db_name, null, db_ver);
    }

    public db_adapter open() {
        sqdb = dbh.getWritableDatabase();
        return this;
    }

    public void close() {
        sqdb.close();
    }

    public long insert(String name, String no) {

        sqdb = dbh.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(name_db, name);
        cv.put(no_db, no);
        return sqdb.insert(tb_name, null, cv);
    }

    public Cursor select() {
        sqdb=dbh.getReadableDatabase();
        Cursor c = sqdb.rawQuery("select * from "+tb_name,null);
        return c;
    }

    public int delete(String no) {
        sqdb=dbh.getWritableDatabase();
        return sqdb.delete(tb_name, " no = \'"+no+"\'", null);
//        sqdb.rawQuery("delete from "+tb_name+" where "+no_db+" = "+"\'"+no+"\'",null);
    }

    public static class dbhelper extends SQLiteOpenHelper {

        public dbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(qq);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + tb_name);
            db.execSQL(qq);

        }

    }
}
