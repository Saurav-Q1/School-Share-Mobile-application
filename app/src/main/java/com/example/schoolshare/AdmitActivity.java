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

public class AdmitActivity extends AppCompatActivity {
    DatabaseHelper myDb;
     private EditText editName,editSurname,editMarks,editTextid;
     private Button buttonAdd;
     private Button buttonViewAll;
     private Button buttonUpdate;
     private Button buttonDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admit);
        myDb = new DatabaseHelper(this);

        buttonDelete = (Button)findViewById(R.id.btnDelete);
        editTextid =(EditText)findViewById(R.id.editTextID);
        editName = (EditText)findViewById(R.id.editText_name);
        editSurname = (EditText)findViewById(R.id.editText_Surname);
        editMarks = (EditText)findViewById(R.id.editText_Marks);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonViewAll = (Button)findViewById(R.id.btnViewRecord);
        buttonUpdate =(Button)findViewById(R.id.btnUpdate);
        AddData();
        viewALL();
        UpdateData();
        DeleteData();




    }
    public void DeleteData(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editTextid.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(AdmitActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(AdmitActivity.this,"Data is not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void UpdateData(){
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(editTextid.getText().toString(),
                        editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());

                if (isUpdate==true){
                    Toast.makeText(AdmitActivity.this,"Data Is updated",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AdmitActivity.this,"Data is not updated",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void AddData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isInserted = myDb.insertData(editName.getText().toString(),
                      editSurname.getText().toString(),
                      editMarks.getText().toString());



//
              if (isInserted==true)
                  Toast.makeText(AdmitActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();


              else
                  Toast.makeText(AdmitActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void viewALL(){
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor res =  myDb.getAllData();
               if(res.getCount()==0){
                   showMessage("Error","No data found");
                   return;
               }
               StringBuffer buffer = new StringBuffer();
               while (res.moveToNext()){
                   buffer.append("Id :"+ res.getString(0)+"\n");
                   buffer.append("Name :"+ res.getString(1)+"\n");
                   buffer.append("Surname :"+ res.getString(2)+"\n");
                   buffer.append("Marks :"+ res.getString(3)+"\n\n");
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
