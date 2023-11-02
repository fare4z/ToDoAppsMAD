package com.fareez.todoapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Open the database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    // Close the database
    public void close() {
        dbHelper.close();
    }

    private static final String TABLE_NAME = "tblUser";

    // Insert a new record into the database
    public long insertData(String name, int age, String password) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("password", password);

        return database.insert("tblUser", null, values);
    }

    // Retrieve records from the database
    public Cursor getAllData() {
        String[] allColumns = {"id", "name", "age", "password"};
        return database.query(TABLE_NAME, allColumns, null, null, null, null, null);
    }

    // Update a record in the database
    public int updateData(long id, String name, int age, String password) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("password", password);

        return database.update(TABLE_NAME, values, "id = ?", new String[]{String.valueOf(id)});
    }

    // Delete a record from the database
    public void deleteData(long id) {
        database.delete(TABLE_NAME, "id = " + id, null);
    }
}
