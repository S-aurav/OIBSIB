package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.todo.Utils.DataBaseHelper;
import com.example.todo.databinding.ActivityTaskViewBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class TaskView extends AppCompatActivity {

    private ActivityTaskViewBinding binding;

    String DBname;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        DBname = auth.getUid();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext(), DBname);

        Intent intent = getIntent();
        String TABLENAME = intent.getStringExtra("TABLENAME");
        String TASK = intent.getStringExtra("TASK");
        String DATE = intent.getStringExtra("DATE");
        int STATUS = intent.getIntExtra("STATUS", 0);
        int FAVTASK = intent.getIntExtra("FAVTASK", 0);

        binding.taskTitle.setText(TASK);
        binding.taskDate.setText(DATE);

        if(STATUS==1){
            binding.markCompleted.setText("Completed");
        }else{
            binding.markCompleted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataBaseHelper.updateStatus(TABLENAME, 1, TASK);
                    Snackbar.make(binding.getRoot(), "Task status updated", Snackbar.LENGTH_SHORT).show();
                    binding.markCompleted.setText("Completed");
                }
            });
        }

        binding.deleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper.deleteTask(TABLENAME, TASK);
                finish();
            }
        });

    }
}