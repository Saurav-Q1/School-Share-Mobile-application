package com.example.schoolshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {


    private Button button;
    private Button buttonReg;
    private Button buttonEvent;
    private Button buttonAttendance;
    private Button buttonResult;
    private Button buttonNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        button= (Button)findViewById(R.id.btnTimetable);
        buttonEvent=(Button)findViewById(R.id.btnEvent);
        buttonReg=(Button)findViewById(R.id.btnRegistration);
        buttonAttendance=(Button)findViewById(R.id.btnAttendance);
        buttonResult=(Button)findViewById(R.id.btnResult);
        buttonNotification=(Button)findViewById(R.id.btnNotification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timetable();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event();
            }
        });

        buttonAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendance();
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result();
            }
        });

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });




    }

    private void Timetable(){
        Intent intent = new Intent(ThirdActivity.this,TimetableActivity.class);
        startActivity(intent);

    }

    private void registration(){
        Intent intent = new Intent(ThirdActivity.this,RegistrationActivity.class);
        startActivity(intent);

    }
    private void event(){
       Intent intent = new Intent(ThirdActivity.this,EventActivity.class);
       startActivity(intent);
    }

    private void attendance(){
        Intent intent = new Intent(ThirdActivity.this,AttendanceActivity.class);
        startActivity(intent);

    }

    private void result(){
        Intent intent = new Intent(ThirdActivity.this,ResultActivity.class);
        startActivity(intent);

    }

    private void notification(){
        Intent intent = new Intent(ThirdActivity.this,NotificationActivity.class);
        startActivity(intent);

    }
}
