package com.example.todolist_room_recyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Index;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.todolist_room_recyclerview.ViewModel.MainViewModel;
import com.example.todolist_room_recyclerview.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainViewModel= new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getTaskList().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                CustomAdapter ad = new CustomAdapter((ArrayList<Task>) tasks);
                recyclerView.setAdapter(ad);
            }
        });
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Edit_Task_Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            Task task = new Task(); //If you create some constructor which takes 1 or two parameters then you'll not be able to create an object like this until you have created a constructor which takes 0 parameter
            task.setDescription(data.getStringExtra("description"));
            task.setTopic(data.getStringExtra("topic"));
            mainViewModel.insert(task);
            Toast.makeText(this, "Task has been added", Toast.LENGTH_SHORT).show();
        }
    }
}