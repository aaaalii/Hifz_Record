package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnrollStudent extends AppCompatActivity {
    EditText name, age, sabaq;
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
        textView = findViewById(R.id.textView3);

        sabaq = findViewById(R.id.sabaq);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sbq = sabaq.getText().toString();
                String n = name.getText().toString();
                String a = age.getText().toString();

                Student student = new Student(n, a);
                if(sbq == null){
                    studentsDbHelper.insertStudent(student);
                    textView.setText("Student Enrolled");
                }
                else{
                    SabaqDbHelper sabaqDbHelper = new SabaqDbHelper(EnrollStudent.this);
                    sabaqDbHelper.insertSabaq(sabaq.toString());
                    studentsDbHelper.insertStudent(student);
                    textView.setText("Student Enrolled");

                }
            }
        });








    }
}