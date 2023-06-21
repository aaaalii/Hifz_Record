package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.List;

public class seeRecord extends AppCompatActivity {

        RecyclerView recyclerView;
        RecyclerViewAdapter2 adapter;
        //RecyclerViewAdapter ad;
        RecyclerView.LayoutManager layoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_see_record);

            Intent intent = getIntent();

            String iid = intent.getStringExtra("roll");

            //ad = new RecyclerViewAdapter()
//        adapter.setOnItemClickListener(this); // Set the listener

            recyclerView = findViewById(R.id.rv);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);

            StudentsDbHelper studentsDbHelper = new StudentsDbHelper(this);
            SQLiteDatabase db = studentsDbHelper.getWritableDatabase();

            List<StudentFullRecord> students = studentsDbHelper.getStudentRecord(iid);

            recyclerView.setLayoutManager(layoutManager);

            adapter = new RecyclerViewAdapter2(students);
            recyclerView.setAdapter(adapter);

    }
}