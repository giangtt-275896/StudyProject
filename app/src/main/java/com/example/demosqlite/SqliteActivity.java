package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.demorecycleview.R;

import java.util.ArrayList;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener{

    private SQLHandler mSqlHandler;
    private ArrayList<Student> mAllStudents;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        tvCount = findViewById(R.id.tvCount);
        tvCount.setOnClickListener(this);
        mSqlHandler = new SQLHandler(this);
        //createData();
        mAllStudents = new ArrayList<Student>();
        getAllRow();
    }

    private void createData() {
        Student student = new Student();
        // Insert
        student.setStudentId("1");
        student.setStudentName("Peter");
        student.setStudentAddress("England");
        mSqlHandler.insertRow(student);
        // Insert
        student.setStudentId("2");
        student.setStudentName("Mary");
        student.setStudentAddress("French");
        mSqlHandler.insertRow(student);
    }

    private void getAllRow() {
        mAllStudents = mSqlHandler.getAllRows();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCount:
                tvCount.setText("Student table size: " + mAllStudents.size());
                break;
        }
    }
}