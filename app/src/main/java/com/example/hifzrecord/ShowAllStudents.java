package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShowAllStudents extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    //RecyclerViewAdapter ad;
    RecyclerView.LayoutManager layoutManager;
    String rollToBeSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_students);

        Intent intent = getIntent();

        //ad = new RecyclerViewAdapter()
//        adapter.setOnItemClickListener(this); // Set the listener

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        StudentsDbHelper studentsDbHelper = new StudentsDbHelper(this);
        SQLiteDatabase db = studentsDbHelper.getWritableDatabase();

        List<Student> students = studentsDbHelper.selectAllStudents();

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(students);
        adapter.setOnItemClickListener(this); // Set the listener
        recyclerView.setAdapter(adapter);
        }

        @Override
        public void onItemClick(int id){
            Intent intent = new Intent(this, seeRecord.class);
            intent.putExtra("roll", id);
            //Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
}