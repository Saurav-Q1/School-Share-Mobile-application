package com.example.schoolshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {

    private Button buttonAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        buttonAd = (Button)findViewById(R.id.btnAdmit);
        buttonAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                admit();
            }
        });
    }

    private void admit(){
        Intent intent = new Intent(RegistrationActivity.this,AdmitActivity.class);
        startActivity(intent);
    }

}
