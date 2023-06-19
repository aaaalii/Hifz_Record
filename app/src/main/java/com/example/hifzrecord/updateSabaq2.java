package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class updateSabaq2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabaq2);

        Intent intent = getIntent();

        String rollno = intent.getStringExtra("rollno");
        StudentsDbHelper studentsDbHelper = new StudentsDbHelper(this);

        List<Student> students = studentsDbHelper.selectAllStudents();

        for(int i= 0; i<students.size();i++){

        }
    }
}