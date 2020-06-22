package com.example.demorecycleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demorecycleview.R;
import com.example.demorecycleview.adapter.RecyclerViewAdapter;
import com.example.demorecycleview.data.User;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private ArrayList<User> mData;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        // Data
        mData = new ArrayList<User>();
        createData(mData);
        // RecyclerView
        mRecyclerView = findViewById(R.id.rv);
        // RecyclerView Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView Adapter
        mRecyclerViewAdapter = new RecyclerViewAdapter(this, mData);
        // Connect
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void createData(ArrayList<User> data){
        User user1 = new User("Peter", "England");
        data.add(user1);
        User user2 = new User("Mary", "France");
        data.add(user2);
        User user3 = new User("Deng", "China");
        data.add(user3);
        User user4 = new User("Kim", "Korean");
        data.add(user4);
        User user5 = new User("Bin", "US");
        data.add(user5);
    }
}