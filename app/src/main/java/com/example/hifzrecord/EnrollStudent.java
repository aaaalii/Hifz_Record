package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnrollStudent extends AppCompatActivity {
    EditText name, age, rollno;
    Button enroll;
    TextView textView;

    StudentsDbHelper studentsDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_student);

        Intent intent = getIntent();

        studentsDbHelper = new StudentsDbHelper(this);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        enroll = findViewById(R.id.enrollStudent);
        rollno = findViewById(R.id.rollno);
        textView = findViewById(R.id.textView3);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString();
                String a = age.getText().toString();
                String r = rollno.getText().toString();

                Student student = new Student(Integer.parseInt(r), n, a, null);

                if(n == null || a == null || r == null){
                    // Add Toast
                }
                else {
                    studentsDbHelper.insertStudent(student);
                }
            }
        });








    }
}