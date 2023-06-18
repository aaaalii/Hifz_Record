package com.example.hifzrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateSabaq extends AppCompatActivity {

    EditText rollno;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabaq);

        Intent intent = getIntent();

        rollno = findViewById(R.id.sabaqrollno);
        proceed = findViewById(R.id.next);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UpdateSabaq.this, updateSabaq2.class);
                intent1.putExtra("rollno", rollno.getText().toString());

                startActivity(intent1);
            }
        });

    }
}