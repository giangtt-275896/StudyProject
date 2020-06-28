package com.example.demoroomdata.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.demorecycleview.R;
import com.example.demoroomdata.adapter.RoomAdapter;
import com.example.demoroomdata.data.Items;
import com.example.demoroomdata.roomdatabase.AppDatabase;
import com.example.demoroomdata.roomdatabase.ItemDAO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class RoomActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;
    private ItemDAO mItemDAO;
    private List<Items> mItemsList;
    private Items mItems;
    private RoomAdapter mRoomAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mAppDatabase = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        mItemDAO = mAppDatabase.getItemDAO();
        //createData();
        mItemsList = new ArrayList<>();
        //mItemsList = mItemDAO.getItems();
        getListItems();
        mRoomAdapter = new RoomAdapter(this, mItemsList);
        mRecyclerView = findViewById(R.id.rvRoomDatabase);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRoomAdapter);
    }

    private void createData() {
        for(int i=0; i<100; i++) {
            mItems = new Items();
            mItems.setName("Name: "+i);
            mItems.setDescription("Description: "+i);
            mItems.setQuantity(i);
            mItemDAO.insert(mItems);
        }
    }
    private void getListItems() {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mItemDAO.getItems();
                Log.d("getListItems", "fromAction");
            }
        })       // observeOn(AndroidSchedulers.mainThread()): Điều này báo cho Observer nhận data ở Android Main Thread
                .observeOn(AndroidSchedulers.mainThread())
                // subcribeOn(Schedulers.io()): Điều này bảo Observable chạy task tron background thread
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        mItemsList = mItemDAO.getItems();
                        mRoomAdapter.notifyDataSetChanged();
                        Log.d("getListItems", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getListItems", "Problem");
                    }
                });
    }
}