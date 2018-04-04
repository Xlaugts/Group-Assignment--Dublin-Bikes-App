package com.example.groupassignment.dublinbike;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.example.groupassignment.dublinbike.TableData.users.COMMENT;
import static com.example.groupassignment.dublinbike.TableData.users.ENDNAME;
import static com.example.groupassignment.dublinbike.TableData.users.STARTNAME;
import static com.example.groupassignment.dublinbike.TableData.users.TABLE_NAME_DATA;
import static com.example.groupassignment.dublinbike.TableData.users.TRIPDATE;
import static com.example.groupassignment.dublinbike.TableData.users.TRIPNAME;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class DatabaseOperation extends SQLiteOpenHelper{

    public  static String getPassword="";


    public static final int database_version=6;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.users.TABLE_NAME + "("+ TableData.users.USERNAME +" TEXT," + TableData.users.PASSWORD + " TEXT,"+ TableData.users.EMAIL + " TEXT );";
    public String CREATE_QUERY_DATA = "CREATE TABLE " + TableData.users.TABLE_NAME_DATA + "("+ TableData.users.TRIPNAME +" TEXT," + TableData.users.STARTNAME + " TEXT,"+ TableData.users.TRIPDATE + " TEXT,"+ TableData.users.ENDNAME + " TEXT,"+ TableData.users.COMMENT + " TEXT );";

    public DatabaseOperation(Context context) {
        super(context, TableData.users.DATABASE_NAME, null, database_version);
        Log.d("MY MSG","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("MY MSG","Login Table Created");
        db.execSQL(CREATE_QUERY_DATA);
        Log.d("MY MSG","Data Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TableData.users.TABLE_NAME + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TableData.users.TABLE_NAME_DATA + "'");
        onCreate(db);
    }

    public void dropDatabase(DatabaseOperation dop){
        SQLiteDatabase mydb = dop.getWritableDatabase();
        mydb.execSQL("DROP TABLE " + TableData.users.TABLE_NAME);
        Log.d("MY MSG"," Login Tables Deleted!");
        mydb.execSQL("DROP TABLE " + TableData.users.TABLE_NAME_DATA);
        Log.d("MY MSG"," Data Tables Deleted!");
    }



    public void putRecord(DatabaseOperation dop, String username, String password, String email){
        SQLiteDatabase mydb = dop.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put(TableData.users.USERNAME,username);
        cv.put(TableData.users.PASSWORD,password);
        cv.put(TableData.users.EMAIL,email);
        long value = mydb.insert(TableData.users.TABLE_NAME,null,cv);
        Log.d("MY MSG","Row Inserted");
    }

    public Cursor getRecord(DatabaseOperation dop){
        SQLiteDatabase DB = dop.getReadableDatabase();
        String[] data = {TableData.users.USERNAME,TableData.users.PASSWORD,TableData.users.EMAIL};
        Cursor cr = DB.query(TableData.users.TABLE_NAME,data,null,null,null,null,null);
        Log.d("MY MSG", "Getting Records...");
        return cr;
    }

    public void insert (DatabaseOperation databaseHelper, String TripName, String StartName, String EndName, String Comment, String TripDate) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableData.users.TRIPNAME, TripName);
        values.put(TableData.users.STARTNAME, StartName);
        values.put(TableData.users.ENDNAME, EndName);
        values.put(TableData.users.COMMENT, Comment);
        values.put(TableData.users.TRIPDATE, TripDate);
        long student_Id = db.insert(TABLE_NAME_DATA, null, values);
        Log.d("MY MSG", "Row Inserted");
    }



    // get all favourite trip data
    public ArrayList<TableData> getAllUsers () {
        ArrayList<TableData> favouriteArrayList = new ArrayList<TableData>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME_DATA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                TableData tableData = new TableData();
                tableData.setTripName(c.getString(c.getColumnIndex(TRIPNAME)));
                tableData.setStartName(c.getString(c.getColumnIndex(STARTNAME)));
                tableData.setEndName(c.getString(c.getColumnIndex(ENDNAME)));
                tableData.setComment(c.getString(c.getColumnIndex(COMMENT)));
                tableData.setTripDate(c.getString(c.getColumnIndex(TRIPDATE)));

                // adding to favourite tip list
                favouriteArrayList.add(tableData);
            } while (c.moveToNext());
        }
        return favouriteArrayList;
    }


    // method to get the password  of userName
    public String getSinlgeEntry(String userName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query("users", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
            return "NOT EXIST";
        cursor.moveToFirst();
        getPassword= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return getPassword;
    }




}
