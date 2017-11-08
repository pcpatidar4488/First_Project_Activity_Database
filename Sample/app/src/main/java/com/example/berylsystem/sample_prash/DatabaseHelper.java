package com.example.berylsystem.sample_prash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.RippleDrawable;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DTATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    public DatabaseHelper(Context context) {
        super(context, DTATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTERGER PRIMARY KEY,NAME TEXT,ROLL_NO NONE ,MOBILE_NUMBER TEXT,CLASS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String rollno,String mobile_number, String etclass) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("ROLL_NO",rollno);
        contentValues.put("MOBILE_NUMBER", mobile_number);
        contentValues.put("CLASS", etclass);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public void updateData(String name,String rollno,String mobile,String etclass){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
       // contentValues.put("ROLL_NO", rollno);
        contentValues.put("MOBILE_NUMBER",mobile);
        contentValues.put("CLASS",etclass);
       db.update(TABLE_NAME,contentValues,"ROLL_NO = '"+rollno+"'",null);
    }

  /*  public Cursor getInformation()
    {
        Cursor cursor = getWritableDatabase().query("students",new String[] {"NAME", "ROLL_NO"},null, null, null, null, null);

        return cursor;
    }*/

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;
    }

}