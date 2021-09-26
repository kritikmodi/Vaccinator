package com.example.vaccinator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//class to extend SQLiteOpenHelper to use SQLite and create/modify databases
public class DBHelper extends SQLiteOpenHelper {


    //constructor
    public DBHelper(Context context) {

        super(context, "RegisterLogin.db", null, 1);
        //database created by the name "RegisterLogin.db"

    }

    //function to create tables in the database
    @Override
    public void onCreate(SQLiteDatabase usersDB) {

         //the following line is used to invoke a query in the SQLite database
         //this query creates a table with the given columns
         usersDB.execSQL("create Table users(name Text, dob Text, aadhaar_number Text primary key, city Text, state Text, pincode Text, phone_number Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase usersDB, int oldVersion, int newVersion) {

        usersDB.execSQL("drop Table if exists users");

    }

    //function to insert values in the database
    public Boolean insertData(String name, String dob, String aadhaar_number, String city, String state, String pincode, String phone_number){

        SQLiteDatabase usersDB = this.getWritableDatabase();
        //the above line is needed to make edits to the database
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("aadhaar_number", aadhaar_number);
        contentValues.put("city", city);
        contentValues.put("state", state);
        contentValues.put("pincode", pincode);
        contentValues.put("phone_number", phone_number);
        long result = usersDB.insert("users", null, contentValues);
        //the above line will return -1 if data insertion is unsuccessful
        if(result==-1)
            return false;
        else
            return true;

    }

    //function to check whether user already exists in the database
    public Boolean checkUserExists(String aadhaar_number){

        SQLiteDatabase usersDB = this.getWritableDatabase();
        Cursor cursor = usersDB.rawQuery("select * from users where aadhaar_number = ?", new String[] {aadhaar_number});
        //cursor is like a counter that counts the number of times a particular entry is present in the database
        //therefore if the value of cursor>0, it means that an entry with that parameter is already present in the database
        //so we add the user details in the table only if this function returns false
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
}
