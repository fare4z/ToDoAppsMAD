package com.fareez.todoapps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todoApps.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_CREATE_USER =
            "CREATE TABLE tblUser (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "password TEXT, " +
                    "age INTEGER);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the database and tables when it doesn't exist
        db.execSQL(TABLE_CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade the database when the version changes
        db.execSQL("DROP TABLE IF EXISTS tblUser");
        onCreate(db);
    }
}
