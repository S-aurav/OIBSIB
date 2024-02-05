package com.example.todo.Adapters;

import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.MainActivity;
import com.example.todo.R;
import com.example.todo.TaskView;
import com.example.todo.Utils.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    ArrayList<String> taskTitle, taskDate;
    ArrayList<Integer> taskStatus;
    ArrayList<Integer> taskFav;
    private OnItemClickListener listener;
    public RecyclerTaskAdapter(ArrayList<String> taskTitle, ArrayList<String> taskDate,  ArrayList<Integer> taskStatus, ArrayList<Integer> taskFav, OnItemClickListener listener){
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
        this.taskFav = taskFav;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_task_view, parent, false);

        return new TaskViewHolder(view, listener, taskTitle, taskDate, taskStatus, taskFav);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            Log.e("QWERTY", String.valueOf(taskTitle.size()));
            Log.e("POSITION", String.valueOf(position));
            Log.e("UIOP", String.valueOf(taskTitle.get(position)));

            holder.taskText.setText(taskTitle.get(position));
            holder.taskRadio.setChecked(taskStatus.get(position) == 1);
            holder.setFav.setChecked(taskFav.get(position) == 1);

            if(taskStatus.get(position) == 1){
                holder.taskText.setPaintFlags(holder.taskText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }


    }

    @Override
    public int getItemCount() {
        return taskTitle.size();
    }

    public interface OnItemClickListener {

        void onItemClick(int position);
        void onTextViewClick(int position, String TASK, String DATE, int STATUS, int FAVTASK);
        void onTaskCompleteRadio(int position, boolean isChecked, String TASK);

        void onSetFavRadio(int position, boolean isChecked, String TASK);


    }
}
