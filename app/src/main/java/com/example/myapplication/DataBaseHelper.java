package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String Database_name = "Test_DB";
    public static final int Database_ver = 1;


    private static final String COL_PHONE = "phonenumber";
    private static final String COL_PASSWORD = "password";
    private static final String COL_FIRSTNAME = "firstname";
    private static final String COL_ID = "id";
    private static final String TABLE_REGISTER = "REGISTERTABLE";


    public DataBaseHelper(Context context) {

        super(context, Database_name ,null, Database_ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_REGISTER + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FIRSTNAME + " TEXT, " +
                COL_PASSWORD + " TEXT, " +
                COL_PHONE + " TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_REGISTER);
        onCreate(db);

    }

    public boolean insertUser(String firstname, String password, String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_PHONE, phonenumber);
        long result = db.insert(TABLE_REGISTER, null, contentValues);

        return result != -1;
    }


    public boolean checkusrbyusername(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REGISTER + " WHERE " + COL_FIRSTNAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});

        boolean exists = cursor.getCount() > 0;
        cursor.close();  // Always close the cursor to avoid memory leaks.
        return exists;
    }

}
