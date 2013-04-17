package com.example.ccapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ccapp.db";
    private static final int DATABASE_VERSION = 1;
    
    public TaskDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase database){
        TaskTable.onCreate(database);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        TaskTable.onUpgrade(database, oldVersion, newVersion);
    }
}
