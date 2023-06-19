package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateSabaq extends AppCompatActivity {

    EditText rollno;
    Button proceed;
    boolean chk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabaq);

        Intent intent = getIntent();

        rollno = findViewById(R.id.sabaqrollno);
        proceed = findViewById(R.id.next);

        String roll = rollno.getText().toString();
        int r = Integer.parseInt(roll);

        StudentsDbHelper studentsDbHelper = new StudentsDbHelper(this);

        List<Student> students = studentsDbHelper.selectAllStudents();

        for(int i= 0; i<students.size();i++){
            Student s = students.get(i);
            if(s.getId() == r){
                chk = true;
                return;
            }
        }

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk){
                    Intent intent1 = new Intent(UpdateSabaq.this, updateSabaq2.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(UpdateSabaq.this, "Student not found!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}