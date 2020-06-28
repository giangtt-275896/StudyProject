package com.example.demoroomdata.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.demoroomdata.data.Items;

@Database(entities = {Items.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}
