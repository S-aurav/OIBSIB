package com.example.todo.Utils;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private String DATABASE_NAME;
    private Context context;



    public DataBaseHelper(@Nullable Context context , String DATABASE_NAME) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE Fav_Task" +
                " (" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TASK" + " TEXT, " +
                "DATE" + " TEXT, " +
                "STATUS" + " INTEGER, " +
                "FAVTASK" + " INTEGER, " +
                "FROMTABLE" + " TEXT);";

        db.execSQL(query);

        query = "CREATE TABLE ALLTASK" +
                " (" + "_ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TABLE_NAME" + " TEXT);";

        db.execSQL(query);

        ContentValues cv = new ContentValues();
        cv.put("TABLE_NAME", "Fav_Task");

        db.insert("ALLTASK", null, cv);
    }

    public void getTableList(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("");
    }

    public void createTable(String TABLE_NAME){
        SQLiteDatabase db = this.getWritableDatabase();

        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        if (!isTableExists(db, TABLE_NAME)) {
            // Table does not exist, create it
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,TASK TEXT, DATE INTEGER, STATUS INTEGER, FAVTASK INTEGER)");
            ContentValues cv = new ContentValues();
            cv.put("TABLE_NAME", TABLE_NAME);
            long result = db.insert("ALLTASK",null, cv);
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
            }
        }else{

        }
    }

    @SuppressLint("Range")
    public void deleteTable(String TABLE_NAME){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        if(TABLE_NAME.equals("")){
            Toast.makeText(context, "Can't delete Starred list!", Toast.LENGTH_SHORT).show();
        }else if(TABLE_NAME.equals("My_Task")){
            Toast.makeText(context, "Can't delete Default list!", Toast.LENGTH_SHORT).show();
        }else {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            String whereClause = "TABLE_NAME = ?";

            String[] whereArgs = new String[]{TABLE_NAME};

            int rowsDeleted = db.delete("ALLTASK", whereClause, whereArgs);

            if (rowsDeleted > 0) {
                // The row was successfully deleted
                Toast.makeText(context.getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            } else {
                // No rows were deleted or an error occurred
            }
        }
    }

    public void updateTable(String oldTitle, String newTitle){

        if(oldTitle.contains(" ") || newTitle.contains(" ")){
            oldTitle = oldTitle.replace(" ", "_");
            newTitle = newTitle.replace(" ", "_");
        }

        if(oldTitle.equals("")){
            Toast.makeText(context, "Can't rename Starred list!", Toast.LENGTH_SHORT).show();
        }else if(oldTitle.equals("My_Task")){
            Toast.makeText(context, "Can't rename Default list!", Toast.LENGTH_SHORT).show();
        }else{
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("ALTER TABLE " + oldTitle + " RENAME TO " + newTitle);
            ContentValues cv = new ContentValues();
            cv.put("TABLE_NAME", newTitle);

            db.update("ALLTASK", cv, "TABLE_NAME=?", new String[]{oldTitle});
        }
    }

    public void addTask(String TABLE_NAME, String title, String date, int status, int favtask) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        if(!isTaskExists(db, TABLE_NAME, title)){
            cv.put("TASK", title);
            cv.put("DATE", date);
            cv.put("STATUS", status);
            cv.put("FAVTASK", favtask);
            long result = db.insert(TABLE_NAME,null, cv);
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {

                if (favtask == 1) {
                    cv.put("FROMTABLE", TABLE_NAME);
                    // Insert or update the corresponding data in the fav table
                    db.insert("Fav_Task", null, cv);
                }
//                Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void deleteTask(String TABLE_NAME, String TASK){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }
        SQLiteDatabase db = getWritableDatabase();
        long res = db.delete(TABLE_NAME , "TASK=?" , new String[]{TASK});

        if(res == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else {
            deleteFavTask(TABLE_NAME, TASK);
//            Toast.makeText(context, "deleted Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteFavTask(String TABLE_NAME, String TASK){
        SQLiteDatabase db = getWritableDatabase();
//        String taskName = isFavTask(TABLE_NAME, String TASK);

        //if(taskName!=null){
            db.delete("Fav_Task","TASK=?", new String[]{TASK});
        //}
    }

    private void updateFavTable(String TABLE_NAME, String TASK, ContentValues cv) {
        SQLiteDatabase db = getWritableDatabase();


        // Insert or update the corresponding data in the fav table
        db.update("Fav_Task", cv, "TASK=?", new String[]{TASK});

    }

    @SuppressLint("Range")
    public void updateTask(String TABLE_NAME, String oldTASK, String newTASK){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TASK", newTASK);

        if (!TABLE_NAME.equals("Fav_Task")) {
            long result = db.update(TABLE_NAME, cv, "TASK=?", new String[]{oldTASK});
            if(result == -1){
                Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
            }else {
                db.update("Fav_Task", cv, "TASK=?", new String[]{newTASK});
            }
        }else{
            db.update("Fav_Task", cv, "TASK=?", new String[]{newTASK});

            String tableName = null;

            Cursor cursor = db.rawQuery("SELECT * FROM Fav_Task WHERE TASK=?", new String[]{newTASK});
            Log.e("SAURAV", "CURSOR "+cursor.getColumnIndex("FROMTABLE"));
            if (cursor != null) {
                try {
                    while (cursor.moveToNext()) {
                        tableName = cursor.getString(cursor.getColumnIndex("FROMTABLE"));
                        Log.e("SAURAV", "CURSOR "+cursor.getColumnIndex("FROMTABLE"));
                    }
                } finally {
                    cursor.close();
                }
            }else{
                Log.e("SAURAV", "NULL CURSOR");
            }

            if(tableName!=null){
                db.update(tableName, cv, "TASK=?", new String[]{oldTASK});
            }else{
                Log.e("SAURAV", "NULL TABLENAME");
            }
        }

    }

    public void updateDate(String TABLE_NAME, String date, String TASK){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("DATE", date);

        if(!TABLE_NAME.equals("Fav_Task")) {
            long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(TASK)});
            if (result == -1) {
                Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
            } else {
                updateFavTable(TABLE_NAME, TASK, cv);
//            Toast.makeText(context, "345!", Toast.LENGTH_SHORT).show();
            }
        }else{
            updateFavTable(TABLE_NAME, TASK, cv);
            updateFromFavToOther(TABLE_NAME, TASK, cv);
        }
    }

    public void updateStatus(String TABLE_NAME, int Status, String TASK){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("STATUS", Status);

        if(!TABLE_NAME.equals("Fav_Task")){
            long result = db.update(TABLE_NAME, cv, "TASK=?", new String[]{TASK});
            if(result == -1){
                Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
            }else {
                updateFavTable(TABLE_NAME, TASK, cv);
                //Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            }
        }else{
                Log.e("YADAV", "lol");
                updateFavTable(TABLE_NAME, TASK, cv);
                updateFromFavToOther(TABLE_NAME, TASK, cv);
                //Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateFav(String TABLE_NAME, int favStatus, String TASK){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }
        Log.e("POILK", TABLE_NAME+" "+favStatus+" "+TASK);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FAVTASK", favStatus);
        long result = db.update(TABLE_NAME, cv, "TASK=?", new String[]{TASK});
        if(result == -1){
            Toast.makeText(context, "Failed update", Toast.LENGTH_SHORT).show();
        }else {
            if(favStatus==1){
                //String task = getTask(TABLE_NAME, TASK);
                if(!isTaskExists(db,"Fav_Task", TASK)){
                    String date = getDate(TABLE_NAME, TASK);
                    int status = getStatus(TABLE_NAME, TASK);
                    ContentValues cv1 = new ContentValues();
                    cv1.put("TASK", TASK);
                    cv1.put("DATE", date);
                    cv1.put("STATUS", status);
                    cv1.put("FAVTASK", "1");
                    cv1.put("FROMTABLE", TABLE_NAME);
                    db.insert("Fav_Task", null, cv1);
                }
            }else{
                deleteFavTask(TABLE_NAME, TASK);
            }
//            Toast.makeText(context, "456", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("Range")
    public void updateFromFavToOther(String TABLE_NAME, String TASK, ContentValues cv){
        SQLiteDatabase db = getWritableDatabase();

        Log.e("SAVOUR", TABLE_NAME);

        if(TABLE_NAME.equals("Fav_Task")){
            //String taskName = isFavTask(TABLE_NAME, row_id);
            String tableName = null;

            Cursor cursor = db.rawQuery("SELECT * FROM Fav_Task WHERE TASK=?", new String[]{TASK});
            Log.e("SAVOUR", "CURSOR "+cursor.getColumnIndex("FROMTABLE"));
            if (cursor != null) {
                try {
                    while (cursor.moveToNext()) {
                        tableName = cursor.getString(cursor.getColumnIndex("FROMTABLE"));
                        Log.e("SAVOUR", "CURSOR "+cursor.getColumnIndex("FROMTABLE"));
                    }
                } finally {
                    cursor.close();
                }
            }else{
               Log.e("SAVOUR", "NULL CURSOR");
            }

            if(tableName!=null){
                db.update(tableName, cv, "TASK=?", new String[]{TASK});
            }else{
                Log.e("SAVOUR", "NULL TABLENAME");
            }
        }else{
//            Log.e("SAVOUR", "table "+TABLE_NAME+" row id: "+row_id);
//            db.update("Fav_Task", cv, "ID=?", new String[]{String.valueOf(row_id)});
        }

    }


    private boolean isTableExists(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{tableName});
        try {
            return cursor.getCount() > 0;
        } finally {
            cursor.close();
        }
    }

    private boolean isTaskExists(SQLiteDatabase db, String tableName, String task) {
        Cursor cursor = db.rawQuery("SELECT * FROM "+ tableName + " WHERE TASK=?", new String[]{task});
        try {
            return cursor.getCount() > 0;
        } finally {
            cursor.close();
        }
    }

    public ArrayList<String> getTasksTitle(String TABLE_NAME){

        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        ArrayList<String> tasks = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String tableName = cursor.getString(cursor.getColumnIndex("TASK"));
                    if(tableName.contains("_")){
                        tableName = tableName.replace("_", " ");
                    }
                    tasks.add(tableName);
                }
            } finally {
                cursor.close();
            }
        }

        return tasks;
    }

    public ArrayList<String> getTaskDate(String TABLE_NAME){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        ArrayList<String> dates = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String tableName = cursor.getString(cursor.getColumnIndex("DATE"));

                    dates.add(tableName);
                }
            } finally {
                cursor.close();
            }
        }
        return dates;
    }

    public ArrayList<Integer> getTaskStatus(String TABLE_NAME){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        ArrayList<Integer> statuses = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String tableName = cursor.getString(cursor.getColumnIndex("STATUS"));

                    statuses.add(Integer.valueOf(tableName));
                }
            } finally {
                cursor.close();
            }
        }
        return statuses;
    }

    public ArrayList<Integer> getTaskFav(String TABLE_NAME){
        if(TABLE_NAME.contains(" ")){
            TABLE_NAME = TABLE_NAME.replace(" ", "_");
        }

        ArrayList<Integer> fav = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String tableName = cursor.getString(cursor.getColumnIndex("FAVTASK"));
                    fav.add(Integer.valueOf(tableName));
                }
            } finally {
                cursor.close();
            }
        }
        return fav;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FAVTASK");
        db.execSQL("DROP TABLE IF EXISTS MYTASK");
        onCreate(db);
    }

    public List<String> getAllTables() {
        List<String> tableNames = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ALLTASK", null);

        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String tableName = cursor.getString(cursor.getColumnIndex("TABLE_NAME"));
                    if(tableName.contains("_")){
                        tableName = tableName.replace("_", " ");
                    }
                    tableNames.add(tableName);
                }
            } finally {
                cursor.close();
            }
        }

        return tableNames;
    }

    @SuppressLint("Range")
    public String getTask(String TABLE_NAME, String TASK){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT TASK FROM " + TABLE_NAME + " WHERE TASK=?", new String[]{TASK});
        String taskName = null;

        if(cursor!=null){
            try{
                while(cursor.moveToNext()){
                    taskName = cursor.getString(cursor.getColumnIndex("TASK"));
                }
            } finally{
                cursor.close();
            }
        }

        return taskName;
    }

    @SuppressLint("Range")
    public String getDate(String TABLE_NAME, String TASK){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT DATE FROM " + TABLE_NAME + " WHERE TASK=?", new String[]{TASK});
        String taskDate = null;

        if(cursor!=null){
            try{
                while(cursor.moveToNext()){
                    taskDate = cursor.getString(cursor.getColumnIndex("DATE"));
                }
            } finally{
                cursor.close();
            }
        }

        return taskDate;
    }

    @SuppressLint("Range")
    public int getStatus(String TABLE_NAME, String TASK){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT STATUS FROM " + TABLE_NAME + " WHERE TASK=?", new String[]{TASK});
        int taskStatus = 0;

        if(cursor!=null){
            try{
                while(cursor.moveToNext()){
                    taskStatus = Integer.parseInt(cursor.getString(cursor.getColumnIndex("STATUS")));
                }
            } finally{
                cursor.close();
            }
        }
        return taskStatus;
    }
}
