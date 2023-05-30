package com.example.todolist_room_recyclerview.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolist_room_recyclerview.Task;
import com.example.todolist_room_recyclerview.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel { //AndroidViewModel is a subclass of ViewModel and includes a reference to the Application context allowing access to Android-specific resources and services within the view model.
    private Repository taskRepo;
    private LiveData<List<Task>> taskList;

    public MainViewModel(@NonNull Application application) {
        super(application);
         taskRepo = new Repository(application); //Here we are creating a new instance of "Repository". But the right approach should be, it's object should be made in "MainActivity" and passed into constructor of MainViewModel. Same applies to TaskDao object created in Repository class
        taskList = taskRepo.getAllTasks();
    }
    public void insert(Task task){taskRepo.insertTask(task);}
    public void update(Task task){taskRepo.updateTask(task);}
    public void delete(Task task){taskRepo.deleteTask(task);}
    public LiveData<List<Task>> getTaskList(){return taskList;}

}
