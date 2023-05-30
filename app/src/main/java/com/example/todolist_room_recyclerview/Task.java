package com.example.todolist_room_recyclerview;

import android.content.ContentValues;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_tbl")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name= "topic")
    private String topic;

    @ColumnInfo(name= "description")
    private String description;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
