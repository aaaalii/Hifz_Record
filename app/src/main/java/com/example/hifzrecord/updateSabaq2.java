package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class updateSabaq2 extends AppCompatActivity {

    EditText sabaqSurah, sabaqStart, sabaqEnd, sabqi, manzil;
    Button save;

    //SabaqDbHelper sabaqDbHelper;
    StudentsDbHelper studentsDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabaq2);

        Intent intent = getIntent();
        String rollno = intent.getStringExtra("rollno");

        sabaqSurah = findViewById(R.id.sabaqSurah);
        sabaqStart = findViewById(R.id.sabaqStart);
        sabaqEnd = findViewById(R.id.sabaqEnd);
        sabqi = findViewById(R.id.sabqiSurah);
        manzil = findViewById(R.id.manzilSurah);
        save = findViewById(R.id.save);

//        String s1 = sabaqSurah.getText().toString();
//        String s2 = sabaqStart.getText().toString();
//        String s3 = sabaqEnd.getText().toString();
//        String s4 = sabqi.getText().toString();
//        String s5 = manzil.getText().toString();
//
//        // Validating data
//
//        int n1 = Integer.parseInt(s1);
//        int n2 = Integer.parseInt(s2);
//        int n3 = Integer.parseInt(s3);
//        int n4 = Integer.parseInt(s4);
//        int n5 = Integer.parseInt(s5);
//
//        if(n2 >= n3){
//            Toast.makeText(this, "Starting ayat can not be greater than ending ayat", Toast.LENGTH_SHORT).show();
//            sabaqStart.requestFocus();
//            sabaqEnd.requestFocus();
//        }
//
//        if(n1 >= 114){
//            Toast.makeText(this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
//            sabaqSurah.requestFocus();
//        }
//
//        if(n4 >= 114){
//            Toast.makeText(this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
//            sabqi.requestFocus();
//        }
//
//        if(n5 >= 114){
//            Toast.makeText(this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
//            manzil.requestFocus();
//        }
//        //////////////

        studentsDbHelper = new StudentsDbHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = sabaqSurah.getText().toString();
                String s2 = sabaqStart.getText().toString();
                String s3 = sabaqEnd.getText().toString();
                String s4 = sabqi.getText().toString();
                String s5 = manzil.getText().toString();

                // Validating data

                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                int n3 = Integer.parseInt(s3);
                int n4 = Integer.parseInt(s4);
                int n5 = Integer.parseInt(s5);

                if(n2 >= n3){
                    Toast.makeText(updateSabaq2.this, "Starting ayat can not be greater than ending ayat", Toast.LENGTH_SHORT).show();
                    sabaqStart.requestFocus();
                    sabaqEnd.requestFocus();
                }

                if(n1 >= 114){
                    Toast.makeText(updateSabaq2.this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
                    return;
                    //sabaqSurah.requestFocus();
                }

                if(n4 >= 114){
                    Toast.makeText(updateSabaq2.this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
                    return;
                    //sabqi.requestFocus();
                }

                if(n5 >= 114){
                    Toast.makeText(updateSabaq2.this, "Enter valid surah number", Toast.LENGTH_SHORT).show();
                    return;
//                    manzil.requestFocus();
                }
                //////////////

                long chk = studentsDbHelper.insertAll(s1, s2, s3, s4, s5, rollno);

                if(chk == -1){
                    Toast.makeText(updateSabaq2.this, "Insertion Failed!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(updateSabaq2.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}