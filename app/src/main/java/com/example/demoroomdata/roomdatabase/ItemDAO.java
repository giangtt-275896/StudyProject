package com.example.demoroomdata.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demoroomdata.data.Items;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(Items... items);
    @Update
    public void update(Items... items);
    @Delete
    public void delete(Items item);
    @Query("SELECT * FROM items")
    public List<Items> getItems();
    @Query("SELECT * FROM items WHERE id = :id")
    public Items getItemById(int id);
}
