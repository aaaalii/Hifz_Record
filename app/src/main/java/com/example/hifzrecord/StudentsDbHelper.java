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

    private static final String DATABASE_NAME = "studentsDB";
    public static final String TABLE_NAME = "student";
    public static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLAS = "class";

    // For sabaq table
    public static final String TABLE_NAME_SABQ = "sabaq";
    private static final String COLUMN_SABAQ_SURAH = "sabaqSurah";
    private static final String COLUMN_SABAQ_STARTING_AYAT = "start";
    private static final String COLUMN_SABAQ_ENDING_AYAT = "eynd";
    private static final String COLUMN_SABQI_SURAH = "sabqiSurah";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_PARENT_ID = "parent_id";

    public StudentsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " TEXT,"
                + COLUMN_CLAS + " TEXT"
                + ")";

//        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SABQ + "("
//                + COLUMN_SABAQ_SURAH + "TEXT,"
//                + COLUMN_SABAQ_ENDING_AYAT + "TEXT,"
//                + COLUMN_SABAQ_STARTING_AYAT + "TEXT,"
//                + COLUMN_SABQI_SURAH + "TEXT,"
//                + COLUMN_MANZIL + "TEXT,"
//                + COLUMN_PARENT_ID + " TEXT PRIMARY KEY,"
//                + "FOREIGN KEY(" + COLUMN_PARENT_ID + ") REFERENCES " +
//                TABLE_NAME + "(" + COLUMN_ID + "))";

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SABQ + "("
                + COLUMN_SABAQ_SURAH + " TEXT,"
                + COLUMN_SABAQ_ENDING_AYAT + " TEXT,"
                + COLUMN_SABAQ_STARTING_AYAT + " TEXT,"
                + COLUMN_SABQI_SURAH + " TEXT,"
                + COLUMN_MANZIL + " TEXT,"
                + COLUMN_PARENT_ID + " TEXT,"
                + "FOREIGN KEY(" + COLUMN_PARENT_ID + ") REFERENCES " +
                TABLE_NAME + "(" + COLUMN_ID + "))";

        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        String sql2 = "DROP TABLE IF EXISTS "+ TABLE_NAME_SABQ;
        db.execSQL(sql);
        db.execSQL(sql2);
        onCreate(db);
    }

    public long insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ID, student.getId());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLAS, student.getClas());

        long insert = db.insert(TABLE_NAME, null, values);
        db.close();

        return insert;
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  String rollNo = cursor.getString(cursor.getColumnIndex(COLUMN_AGE));
                @SuppressLint("Range") String clas = cursor.getString(cursor.getColumnIndex(COLUMN_CLAS));
                students.add(new Student(id, name, rollNo, clas));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    public long insertAll(String sabaqSurah, String sabaqStart, String sabaqEnd, String sabqi, String manzil, String id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MANZIL, manzil);
        values.put(COLUMN_PARENT_ID, id);
        values.put(COLUMN_SABQI_SURAH, sabqi);
        values.put(COLUMN_SABAQ_ENDING_AYAT, sabaqEnd);
        values.put(COLUMN_SABAQ_STARTING_AYAT, sabaqStart);
        values.put(COLUMN_SABAQ_SURAH, sabaqSurah);

        long chk = db.insert(TABLE_NAME_SABQ, null, values);
        db.close();

        return chk;
    }

    public void getStudentRecord(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PARENT_ID, id);

        db.g
    }
}