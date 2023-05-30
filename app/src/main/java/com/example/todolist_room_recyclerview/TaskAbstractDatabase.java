package com.example.todolist_room_recyclerview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Task.class}, version = 1)
public abstract  class TaskAbstractDatabase extends RoomDatabase {
    private static TaskAbstractDatabase INSTANCE;
    public static synchronized TaskAbstractDatabase getDatabase(Context context){ //"synchronized" keyword will make sure it's thread safe
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,TaskAbstractDatabase.class,"task_db")
                    .fallbackToDestructiveMigration() //In some cases changes in schema is not possible, in that case "fallbackToDestructiveMigration()" will destroy whole previous data and create the database with new features provided
                    .build();
        }
        return INSTANCE;
    }
    public  abstract TaskDao getTaskDao();
}
