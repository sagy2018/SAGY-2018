package com.example.jason.sagy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by goa on 22/1/18.
 */

public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_STATEMENT = "CREATE TABLE " + ContractClass.Utils.TABLE_NAME +
                " ( " + ContractClass.Utils.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ContractClass.Utils.COLUMN_CONTENT + " TEXT, " + ContractClass.Utils.COLUMN_CONTENT + " TEXT );";
        Log.i("SQL", "Statement " + SQL_STATEMENT);

        db.execSQL(SQL_STATEMENT);

    }

    public void insertData(String title, String content, SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        values.put(ContractClass.Utils.COLUMN_TITLE, title);
        values.put(ContractClass.Utils.COLUMN_CONTENT, content);

        long id = db.insert(ContractClass.Utils.TABLE_NAME, null, values);
        Log.i("ID", "insertData: " + id);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ContractClass.Utils.TABLE_NAME);

        onCreate(db);
    }
}
