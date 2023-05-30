package com.example.todolist_room_recyclerview;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

    @Query("select * from task_tbl") //This query returns a Cursor object but "LiveData<List<Task>>" can handle it
    LiveData<List<Task>> getAllTasks();
}
