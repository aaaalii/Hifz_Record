package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnrollStudent extends AppCompatActivity {

    EditText name, age, sabaq;
    Button enroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_student);

        Intent intent = getIntent();

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        enroll = findViewById(R.id.enrollStudent);

        sabaq = findViewById(R.id.sabaq);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sabaq == null){
                    String n = name.toString();
                    int a = Integer.parseInt(age.toString());
                    Student student = new Student(n, a);

                    StudentsDbHelper dbHelper = new StudentsDbHelper(EnrollStudent.this);

                    dbHelper.insertStudent(student);
                }
                else{

                }
            }
        });








    }
}