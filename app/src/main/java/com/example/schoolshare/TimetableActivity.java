package com.example.schoolshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TimetableActivity extends AppCompatActivity {

    private Button button;
    private Button buttonSu;
    private Button buttonMo;
    private Button buttonTu;
    private Button buttonWe;
    private Button buttonTh;
    private Button buttonFr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        button = (Button)findViewById(R.id.btnSaturday);
        buttonSu = (Button)findViewById(R.id.btnSunday);
        buttonMo = (Button)findViewById(R.id.btnMonday);
        buttonTu = (Button)findViewById(R.id.btnTuesday);
        buttonWe = (Button)findViewById(R.id.btnWednesday);
        buttonTh = (Button)findViewById(R.id.btnThursday);
        buttonFr = (Button)findViewById(R.id.btnFriday);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saturday();
            }
        });
        buttonSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunday();
            }
        });
        buttonMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monday();
            }
        });
        buttonTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuesday();
            }
        });
        buttonWe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wednesday();
            }
        });
        buttonTh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thursday();
            }
        });
        buttonFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friday();
            }
        });
    }
    private void saturday(){
        Intent intent = new Intent(TimetableActivity.this,SaturdayActivity.class);
        startActivity(intent);
    }

    private void sunday(){
        Intent intent = new Intent(TimetableActivity.this,SundayActivity.class);
        startActivity(intent);
    }

    private void monday(){
        Intent intent = new Intent(TimetableActivity.this,MondayActivity.class);
        startActivity(intent);
    }

    private void tuesday(){
        Intent intent = new Intent(TimetableActivity.this,TuesdayActivity.class);
        startActivity(intent);
    }

    private void wednesday(){
        Intent intent = new Intent(TimetableActivity.this,WednesdayActivity.class);
        startActivity(intent);
    }

    private void thursday(){
        Intent intent = new Intent(TimetableActivity.this,ThursdayActivity.class);
        startActivity(intent);
    }

    private void friday(){
        Intent intent = new Intent(TimetableActivity.this,FridayActivity.class);
        startActivity(intent);
    }
}
