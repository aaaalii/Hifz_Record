package com.example.hifzrecord;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentsDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "roll_no";
    //private static final String COLUMN_CLASS = "Class";

    public StudentsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static String getTableName(){
        return TABLE_NAME;
    }

    public static String getColumnId(){
        return COLUMN_ID;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        //values.put(COLUMN_CLASS, student.isEnroll());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public void updateStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, student.getName());
//        values.put(COLUMN_AGE, student.getAge());
//        //values.put(COLUMN_ENROLL, student.isEnroll());
//
//        db.update(TABLE_NAME, values, COLUMN_AGE + " = ?", new String[] {Integer.toString(student.getAge())});
//        db.close();
//    }

    public void deleteStudent(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] {Integer.toString(id)});
        db.close();
    }


    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
                //@SuppressLint("Range") boolean isEnroll = cursor.getInt(cursor.getColumnIndex(COLUMN_ENROLL))>0;
                students.add(new Student(name, age));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
