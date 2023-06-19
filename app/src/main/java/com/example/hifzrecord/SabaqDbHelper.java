package com.example.hifzrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SabaqDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "studentsDB";
        private static final String TABLE_NAME = "sabaq_table";

        private static final String COLUMN_SABAQ_SURAH = "sabaqSurah";
        private static final String COLUMN_SABAQ_STARTING_AYAT = "start";
        private static final String COLUMN_SABAQ_ENDING_AYAT = "eynd";
        private static final String COLUMN_SABAQI_SURAH = "sabaqiSurah";
        private static final String COLUMN_MANZIL = "manzil";
        private static final String COLUMN_PARENT_ID = "parent_id";

        public SabaqDbHelper(Context context) {
                super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
                final String SQL_CREATE_TABLE =
                        "CREATE TABLE " + TABLE_NAME + "(" +
                                COLUMN_SABAQ_SURAH + "TEXT, "+
                                COLUMN_SABAQ_STARTING_AYAT + " TEXT," +
                                COLUMN_SABAQ_ENDING_AYAT + "TEXT," +
                                COLUMN_SABAQI_SURAH + " TEXT," +
                                COLUMN_MANZIL + "TEXT," +
                                COLUMN_PARENT_ID + " INTEGER," +
                                "FOREIGN KEY(" + COLUMN_PARENT_ID + ") REFERENCES " +
                                StudentsDbHelper.TABLE_NAME + "(" + StudentsDbHelper.COLUMN_ID + "))";
                db.execSQL(SQL_CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
                db.execSQL(sql);
                onCreate(db);
        }

        public void insertSabaq(String sabaqSurah, String start, String eynd){
                SQLiteDatabase db = this.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(COLUMN_SABAQ_SURAH, sabaqSurah);
                values.put(COLUMN_SABAQ_STARTING_AYAT, start);
                values.put(COLUMN_SABAQ_ENDING_AYAT, eynd);

                //values.put(COLUMN_AGE, student.getAge());
                //values.put(COLUMN_CLASS, student.isEnroll());

                db.insert(TABLE_NAME, null, values);
                db.close();
        }

        public void insertSabaqi(String asbaq){
                SQLiteDatabase db = this.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(COLUMN_SABAQI_SURAH, asbaq);

                //values.put(COLUMN_AGE, student.getAge());
                //values.put(COLUMN_CLASS, student.isEnroll());

                db.insert(TABLE_NAME, null, values);
                db.close();
        }

        public void insertManzil(String manzil){
                SQLiteDatabase db = this.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(COLUMN_MANZIL, manzil);

                //values.put(COLUMN_AGE, student.getAge());
                //values.put(COLUMN_CLASS, student.isEnroll());

                db.insert(TABLE_NAME, null, values);
                db.close();
        }


}


