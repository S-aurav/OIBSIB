package com.example.todo.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

import java.util.ArrayList;

public class TaskViewHolder extends RecyclerView.ViewHolder{

    RadioButton taskRadio, setFav;
    ArrayList<String> taskTitle, taskDate;
    ArrayList<Integer> taskStatus, taskFav;
    TextView taskText;

    private RecyclerTaskAdapter.OnItemClickListener listener;
    public TaskViewHolder(@NonNull View itemView, RecyclerTaskAdapter.OnItemClickListener listener, ArrayList<String> taskTitle, ArrayList<String> taskDate, ArrayList<Integer> taskStatus, ArrayList<Integer> taskFav) {
        super(itemView);
        this.listener = listener;
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
        this.taskFav = taskFav;

        taskRadio = itemView.findViewById(R.id.taskRadio);
        taskText = itemView.findViewById(R.id.taskTitle);
        setFav = itemView.findViewById(R.id.setFav);

        taskText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                        listener.onTextViewClick(getAdapterPosition(), taskTitle.get(getAdapterPosition()), taskDate.get(getAdapterPosition()), taskStatus.get(getAdapterPosition()), taskFav.get(getAdapterPosition()));
                }
            }
        });

        taskRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null) {
                    listener.onTaskCompleteRadio(getAdapterPosition(), isChecked, taskTitle.get(getAdapterPosition()));
                }
            }
        });

        setFav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null) {
                    listener.onSetFavRadio(getAdapterPosition(), isChecked, taskTitle.get(getAdapterPosition()));
                }
            }
        });
    }

}
