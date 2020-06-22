package com.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLHandler extends SQLiteOpenHelper {

    // Database information
    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    // Table Student information
    private static final String TABLE_NAME = "students";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_ADDRESS = "address";

    // Create Student table query
    private static final String CREATE_STUDENT_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
            + COL_ID + " INTEGER PRIMARY KEY, "
            + COL_NAME + " TEXT, "
            + COL_ADDRESS + " TEXT"
            + " )";

    // Delete Student table query
    private static final String DELETE_STUDENT_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_STUDENT_TABLE);
        onCreate(sqLiteDatabase);
    }

    public SQLHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Insert one row
    public long insertRow(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, student.getStudentId());
        contentValues.put(COL_NAME, student.getStudentName());
        contentValues.put(COL_ADDRESS, student.getStudentAddress());
        long newRowId = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    // Get one row
    public void getOneRow(int studentID) {

    }

    // Get all row
    public ArrayList<Student> getAllRows() {
        ArrayList<Student> allStudents = new ArrayList<Student>();
        SQLiteDatabase db = this.getReadableDatabase();
        String getAllQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(getAllQuery, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                Student student = new Student();
                student.setStudentId(cursor.getString(cursor.getColumnIndex(COL_ID)));
                student.setStudentName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                student.setStudentAddress(cursor.getString(cursor.getColumnIndex(COL_ADDRESS)));
                allStudents.add(student);
                cursor.moveToNext();
            }
        }
        db.close();
        cursor.close();
        return allStudents;
    }
}
