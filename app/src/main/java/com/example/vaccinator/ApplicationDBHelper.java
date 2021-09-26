package com.example.vaccinator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ApplicationDBHelper extends SQLiteOpenHelper {

    public ApplicationDBHelper(Context context) {

        super(context, "Application.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase usersDB) {

        //the following line is used to invoke a query in the SQLite database
        //this query creates a table with the given columns
        usersDB.execSQL("create Table application(app_no Text, aadhaar_number Text primary key, slotcode Text, vaccinename Text, vaccineplace Text, dosenumber Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase usersDB, int oldVersion, int newVersion) {

    }

    public Boolean insertData(String app_no, String aadhaar_number, String slotcode, String vaccinename, String vaccineplace, String dosenumber){

        SQLiteDatabase usersDB = this.getWritableDatabase();
        //the above line is needed to make edits to the database
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_no", app_no);
        contentValues.put("aadhaar_number", aadhaar_number);
        contentValues.put("slotcode", slotcode);
        contentValues.put("vaccinename", vaccinename);
        contentValues.put("vaccineplace", vaccineplace);
        contentValues.put("dosenumber", dosenumber);
        long result = usersDB.insert("users", null, contentValues);
        //the above line will return -1 if data insertion is unsuccessful
        if(result==-1)
            return false;
        else
            return true;

    }

}
