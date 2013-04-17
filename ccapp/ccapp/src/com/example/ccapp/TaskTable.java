package com.example.ccapp;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TaskTable {
    
    public static final String TABLE_NAME = "tasks";
    public static final String TASK_ID = "id";
    public static final String TASK_CATEGORY = "category";
    public static final String TASK_SUMMARY = "summary";
    public static final String TASK_DESCRIPTION = "description";
    public static final String TASK_DATE = "date";
    
    private static final String DATABASE_CREATE = "create table"
        + TABLE_NAME
        + "("
        + TASK_ID + " integer primary key autoincrement, "
        + TASK_CATEGORY + " text not null, "
        + TASK_SUMMARY + " text not null, "
        + TASK_DESCRIPTION + " text not null"
        + ");";
        
    public static void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }
    
    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.w(TaskTable.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
        }
}
