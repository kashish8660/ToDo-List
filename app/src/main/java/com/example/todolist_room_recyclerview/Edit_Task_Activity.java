package com.example.todolist_room_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist_room_recyclerview.databinding.ActivityEditTaskBinding;
import com.example.todolist_room_recyclerview.repository.Repository;

import java.util.ArrayList;

public class Edit_Task_Activity extends AppCompatActivity {
    ActivityEditTaskBinding binding;
    TaskDao taskDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityEditTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        taskDao= TaskAbstractDatabase.getDatabase(getApplicationContext()).getTaskDao();
        Intent intent = getIntent();
        binding.editTextText.setText(intent.getStringExtra("topic"));
        Task t= new Task();
        binding.editTextText2.setText(intent.getStringExtra("description"));
binding.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent();
        intent1.putExtra("topic",binding.editTextText.getText().toString().trim() );
        intent1.putExtra("description",binding.editTextText2.getText().toString().trim() );
        setResult(RESULT_OK, intent1);
        finish(); //onDestroy() is called and the previous activity present in the stack resumes execution

    }
});
    }
}