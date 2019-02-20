package com.example.nguyendoannhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguyendoannhan.Data.DBmanager;
import com.example.nguyendoannhan.Model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edt_ID;
    private EditText edt_NAME;
    private EditText edt_ADDRESS;
    private EditText edt_EMAIL;
    private EditText edt_PHONE;

    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInit();
        final DBmanager dBmanager = new DBmanager(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = createStudent();

                if (student != null) {
                    dBmanager.addStudent(student);
                }
                List<Student> listStudent = dBmanager.getAllStudent();
                for (int i = 0; i < listStudent.size(); i++) {
                    String name = listStudent.get(i).getmPhone().toString();
                    Log.d("Nhan", name);
                }
            }
        });

    }

    public void getInit() {
        edt_ID = (EditText) findViewById(R.id.edt_ID);
        edt_NAME = (EditText) findViewById(R.id.edt_Name);
        edt_ADDRESS = (EditText) findViewById(R.id.edt_Address);
        edt_EMAIL = (EditText) findViewById(R.id.edt_Email);
        edt_PHONE = (EditText) findViewById(R.id.edt_Phone);
        btnSave = (Button) findViewById(R.id.btnSave);
    }

    public Student createStudent() {
        Integer mId = Integer.parseInt(edt_ID.getText().toString());
        String mName = edt_NAME.getText().toString();
        String mAddress = edt_ADDRESS.getText().toString();
        String mEmail = edt_EMAIL.getText().toString();
        String mPhone = edt_PHONE.getText().toString();
        Student student = new Student(mId, mName, mAddress, mEmail, mPhone);
        return student;
    }
}
