package com.example.todo.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.todo.Adapters.RecyclerTaskAdapter;
import com.example.todo.Login.UserLogin;
import com.example.todo.MainActivity;
import com.example.todo.R;
import com.example.todo.TaskView;
import com.example.todo.Utils.DataBaseHelper;
import com.example.todo.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Fragment_task extends Fragment implements RecyclerTaskAdapter.OnItemClickListener {

    RecyclerView recyclerView, completedTaskList;
    LinearLayout line;
    ArrayList<String> taskTitle, taskDate;
    ArrayList<Integer> taskStatus, taskFav;
    SwipeRefreshLayout referesh;
    TextView completeText;
    String tabName, DBname;
    FirebaseAuth auth;
    View view;

    public static Fragment_task newInstance(int tabPosition, String tabName){
        Fragment_task fragment = new Fragment_task();
        Bundle args = new Bundle();
        args.putInt("tabPosition", tabPosition);
        args.putString("tabName", tabName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();
        DBname = auth.getUid();

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_task, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        completedTaskList = view.findViewById(R.id.completeTaskList);
        line = view.findViewById(R.id.line);
        completeText = view.findViewById(R.id.completed);
        referesh = view.findViewById(R.id.swipeRefreshLayout);
        referesh.setEnabled(false);


        tabName = getArguments().getString("tabName");


        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), DBname);
        taskTitle = dataBaseHelper.getTasksTitle(tabName);
        taskDate = dataBaseHelper.getTaskDate(tabName);
        taskStatus = dataBaseHelper.getTaskStatus(tabName);
        taskFav = dataBaseHelper.getTaskFav(tabName);

        Log.e("TAB Name", "OK: "+tabName);

        if(taskTitle!=null && !taskTitle.isEmpty()){
            Log.e("ARRAYLIST", taskTitle.get(0));

            filterAndSetTasks();

        }else{
            Log.e("EMPTYYYY", "NOO TASSKK");

            completedTaskList.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
            completeText.setVisibility(View.GONE);

        }

        return view;
    }

    private void filterAndSetTasks() {
        ArrayList<String> incompleteTaskTitles = new ArrayList<>();
        ArrayList<String> incompleteTaskDate = new ArrayList<>();
        ArrayList<Integer> incompleteTaskStatus = new ArrayList<>();
        ArrayList<Integer> incompleteTaskFav = new ArrayList<>();

        ArrayList<String> completedTaskTitles = new ArrayList<>();
        ArrayList<String> completedTaskDate = new ArrayList<>();
        ArrayList<Integer> completedTaskStatus = new ArrayList<>();
        ArrayList<Integer> completedTaskFav = new ArrayList<>();

        for (int i = 0; i < taskTitle.size(); i++) {
            if (taskStatus.get(i) == 0) {
                incompleteTaskTitles.add(taskTitle.get(i));
                incompleteTaskDate.add(taskDate.get(i));
                incompleteTaskStatus.add(taskStatus.get(i));
                incompleteTaskFav.add(taskFav.get(i));
            } else {
                completedTaskTitles.add(taskTitle.get(i));
                completedTaskDate.add(taskDate.get(i));
                completedTaskStatus.add(taskStatus.get(i));
                completedTaskFav.add(taskFav.get(i));
            }
        }


        if(completedTaskTitles.isEmpty()){
            completedTaskList.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

        if(incompleteTaskTitles.isEmpty()){
            recyclerView.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }

        RecyclerTaskAdapter incompleteAdapter = new RecyclerTaskAdapter(incompleteTaskTitles, incompleteTaskDate, incompleteTaskStatus, incompleteTaskFav, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(incompleteAdapter);

        RecyclerTaskAdapter completedAdapter = new RecyclerTaskAdapter(completedTaskTitles, completedTaskDate, completedTaskStatus, completedTaskFav, this);
        completedTaskList.setLayoutManager(new LinearLayoutManager(getContext()));
        completedTaskList.setAdapter(completedAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(), "LOL", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextViewClick(int position, String TASK, String DATE, int STATUS, int FAVTASK) {

        Intent intent = new Intent(getActivity(), TaskView.class);
        intent.putExtra("TASK", TASK);
        intent.putExtra("DATE", DATE);
        intent.putExtra("STATUS", STATUS);
        intent.putExtra("FAVTASK", FAVTASK);
        intent.putExtra("TABLENAME", tabName);
        startActivity(intent);
    }

    @Override
    public void onTaskCompleteRadio(int position, boolean isChecked, String TASK) {
        //Toast.makeText(getContext(), "ASD", Toast.LENGTH_SHORT).show();
        String TABLE_NAME = getArguments().getString("tabName");
        int tabPosition = getArguments().getInt("tabPosition");
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), DBname);

        if(tabPosition!=0) {
            if(isChecked){
                dataBaseHelper.updateStatus(TABLE_NAME, 1, TASK);
            }else{
                dataBaseHelper.updateStatus(TABLE_NAME, 0, TASK);
            }
        }else {
                dataBaseHelper.updateStatus("Fav Task", 1, TASK);
        }
    }

    @Override
    public void onSetFavRadio(int position, boolean isChecked, String TASK) {
//        Toast.makeText(getContext(), "Fav: " + position, Toast.LENGTH_SHORT).show();
        String TABLE_NAME = getArguments().getString("tabName");
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), DBname);
        dataBaseHelper.updateFav(TABLE_NAME, 1, TASK);
    }
}