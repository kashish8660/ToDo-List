package com.example.todolist_room_recyclerview.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.todolist_room_recyclerview.Task;
import com.example.todolist_room_recyclerview.TaskAbstractDatabase;
import com.example.todolist_room_recyclerview.TaskDao;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static TaskDao taskDao; //
    private static LiveData<List<Task>> taskList;

    public Repository(Application application){ //Repository constructor gets all tasks from database to be shown in recyclerView
        taskDao= TaskAbstractDatabase.getDatabase(application).getTaskDao();
        taskList= taskDao.getAllTasks();
    }
    public void insertTask(Task task){
        new InsertItem().execute(task);
    }
    public void updateTask(Task task){
        new UpdateItem().execute(task);
    }
    public void deleteTask(Task task){
        new DeleteItem().execute(task);
    }

    public LiveData<List<Task>> getAllTasks(){
        return taskList;
    }

    private class InsertItem extends AsyncTask<Task, Void, Void>{

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.insertTask(task[0]);
            return null;
        }
    }
    private class UpdateItem extends AsyncTask<Task, Void, Void>{

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.update(task[0]);
            return null;
        }
    }private class DeleteItem extends AsyncTask<Task, Void, Void>{

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.delete(task[0]);
            return null;
        }
    }
}
