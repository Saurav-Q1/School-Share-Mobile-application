package com.example.schoolshare;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AttendanceActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private EditText editText_AttendanceID,editText_StudentName,edit_TextClass,editText_Subject,editText_Date;
    private Button buttonAttend,buttonViewRecords,buttonDelete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        myDb = new DatabaseHelper(this);

          editText_AttendanceID=(EditText)findViewById(R.id.editTextAttendanceID);
          editText_StudentName=(EditText)findViewById(R.id.editTextStudentname);
          edit_TextClass=(EditText)findViewById(R.id.editTextClassAteendance);
          editText_Subject=(EditText)findViewById(R.id.editTextSubject);
          editText_Date=(EditText)findViewById(R.id.editTextDate);

          buttonAttend=(Button)findViewById(R.id.button_attend);
          buttonViewRecords=(Button)findViewById(R.id.button_ViewData);
          buttonDelete2=(Button)findViewById(R.id.button_Attendance_Delete);
          AddData2();
          viewAllData2();
          DeleteData2();



    }




    public void DeleteData2(){
        buttonDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows2 = myDb.deleteData2(editText_AttendanceID.getText().toString());
                if (deleteRows2 > 0)
                    Toast.makeText(AttendanceActivity.this,"Data Is Deleted",Toast.LENGTH_LONG).show();


                else
                    Toast.makeText(AttendanceActivity.this,"Data is not Deleted",Toast.LENGTH_LONG).show();

            }
        });
    }



    public void AddData2(){
        buttonAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted2 = myDb.insertData2(editText_AttendanceID.getText().toString(),
                        editText_StudentName.getText().toString(),
                        edit_TextClass.getText().toString(),
                        editText_Subject.getText().toString(),
                        editText_Date.getText().toString());

                if (isinserted2==true)
                    Toast.makeText(AttendanceActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();


                else
                    Toast.makeText(AttendanceActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAllData2(){
        buttonViewRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData2();
                if (res.getCount()==0){
                    showMessage("Error","No data found");
                        return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID1:"+res.getString(0)+"\n");
                    buffer.append("Student name:"+res.getString(1)+"\n");
                    buffer.append("class:"+res.getString(2)+"\n");
                    buffer.append("Subject:"+res.getString(3)+"\n");
                    buffer.append("Date:"+res.getString(4)+"\n\n\n");
                }
                showMessage("Data",buffer.toString());

            }
        });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
