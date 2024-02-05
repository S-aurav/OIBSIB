package com.example.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.todo.Adapters.VPAdapter;
import com.example.todo.Login.UserLogin;
import com.example.todo.Utils.DataBaseHelper;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.todo.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String photoUrl;
    FirebaseAuth auth;
    ArrayList<String> tabs;
    String DBname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        DBname = auth.getUid();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, DBname);
        dataBaseHelper.createTable("My Task");
        dataBaseHelper.addTask("My_Task", "Download and Install Todo app", "05 Feb, 2024", 1, 1);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            // Get the user's profile photo URL
            photoUrl = firebaseUser.getPhotoUrl().toString();

            Glide
                    .with(getApplicationContext())
                    .load(photoUrl)
                    .circleCrop()
                    .placeholder(R.drawable.google)
                    .into(binding.profile);

        }

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String username = user.getDisplayName();

                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View promptView = layoutInflater.inflate(R.layout.material_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setView(promptView);

                final ImageView profileImage = (ImageView) promptView.findViewById(R.id.profileImage);
                final TextView profileText = (TextView) promptView.findViewById(R.id.profileName);

                Glide
                        .with(getApplicationContext())
                        .load(photoUrl)
                        .circleCrop()
                        .placeholder(R.drawable.google)
                        .into(profileImage);

                profileText.setText(username);
                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(getApplicationContext(), UserLogin.class));
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                // create an alert dialog
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });



        tabs = (ArrayList<String>) dataBaseHelper.getAllTables();
        binding.tabLayout.removeAllTabs();

        for (int k = 0; k <tabs.size(); k++) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(""+tabs.get(k)));
            Log.e("Frag Title", "tab: " + tabs.get(k));
        }
        Log.e("Frag Title0", "tab: " + tabs.size());

        if(tabs.size()==0){
            Toast.makeText(this, "LOL", Toast.LENGTH_SHORT).show();
        }else{
            VPAdapter adapter = new VPAdapter(getSupportFragmentManager(), getLifecycle(), tabs);
            binding.viewPager.setAdapter(adapter);
            binding.viewPager.setOffscreenPageLimit(1);


            new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
                tab.setText(tabs.get(position));
                if(position==0){
                    tab.setIcon(R.drawable.ic_star_ico);
                    tab.setContentDescription("Starred");
                    tab.setText("");
                }
            }).attach();

            if (binding.tabLayout.getTabCount() == 2) {
                binding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
            } else {
                binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        }

        binding.swipeRefreshLayout.setDistanceToTriggerSync(100);
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
                    Log.e("LOL", "onRefresh called from SwipeRefreshLayout");
                    updateReferesh();
                    binding.swipeRefreshLayout.setRefreshing(false);
                }
        );

        binding.addTask.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TabLayout.Tab selectedTab = binding.tabLayout.getTabAt(binding.tabLayout.getSelectedTabPosition());
               if (selectedTab != null && binding.tabLayout.getSelectedTabPosition()!=0) {
                   String tabText = selectedTab.getText().toString();

                   if (tabText.contains(" ")) {
                       tabText = tabText.replace(" ", "_");
                   }
                   showInputTaskDialog(tabText);

               }else if(binding.tabLayout.getSelectedTabPosition()==0){
                   showInputTaskDialog("Fav_Task");
               }

           }
       });

        binding.addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        binding.moreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TabLayout.Tab selectedTab = binding.tabLayout.getTabAt(binding.tabLayout.getSelectedTabPosition());
                if (selectedTab != null) {
                    String tabText = selectedTab.getText().toString();

                    if(tabText.contains(" ")){
                        tabText = tabText.replace(" ", "_");
                    }


                    showDialogSheet(tabText);
                }

            }
        });

    }


    private void showDialogSheet(String TABLE_NAME){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal_bottom_sheet);

        LinearLayout layoutDelete = dialog.findViewById(R.id.layoutDelete);
        LinearLayout layoutRename = dialog.findViewById(R.id.layoutRename);

        layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, DBname);
                dataBaseHelper.deleteTable(TABLE_NAME);
                dialog.cancel();
            }
        });

        layoutRename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputRenameDialog(TABLE_NAME);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    public void showInputRenameDialog(String TABLE_NAME){

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.inputText);
        final TextView inputText = (TextView) promptView.findViewById(R.id.headText);

        editText.setHint("Enter list name");
        inputText.setText("Rename List");
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if(editText.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please enter valid list title", Toast.LENGTH_SHORT).show();
                        }else{
                            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, DBname);
                            dataBaseHelper.updateTable(TABLE_NAME, editText.getText().toString());

                            binding.swipeRefreshLayout.setRefreshing(true);
                            updateReferesh();
                            binding.swipeRefreshLayout.setRefreshing(false);
                        }

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    protected void showInputTaskDialog(String TABLE_NAME) {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.inputText);
        final TextView inputText = (TextView) promptView.findViewById(R.id.headText);

        editText.setHint("Enter Task name");
        inputText.setText("Create new Task");
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if(editText.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please enter valid list title", Toast.LENGTH_SHORT).show();
                        }else{
                            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, DBname);
//                            dataBaseHelper.createTable(editText.getText().toString());
                            dataBaseHelper.addTask(TABLE_NAME, editText.getText().toString(), null, 0, 0);
                            binding.swipeRefreshLayout.setRefreshing(true);
                            updateReferesh();
                            binding.swipeRefreshLayout.setRefreshing(false);

                        }

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void updateReferesh(){
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        finish();
        overridePendingTransition(0, 0);
        startActivity(i);
        overridePendingTransition(0, 0);
    }

    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.inputText);
        final TextView inputText = (TextView) promptView.findViewById(R.id.headText);


        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        if(editText.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please enter valid list title", Toast.LENGTH_SHORT).show();
                        }else{
                            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, DBname);
                            dataBaseHelper.createTable(editText.getText().toString());

                            binding.swipeRefreshLayout.setRefreshing(true);
                            updateReferesh();
                            binding.swipeRefreshLayout.setRefreshing(false);

                        }

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}