package com.example.nguyendoannhan.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.nguyendoannhan.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBmanager extends SQLiteOpenHelper {
    private static String TAG = "DBManager";
    private static String DATABASE_NAME = "DBManager";
    private static String TABLE_NAME = "student";
    private static String ID = "id";
    private static String NAME = "name";
    private static String ADDRESS = "address";
    private static String EMAIL = "email";
    private static String PHONE = "phone";
    private static int VERSION = 1;
    private Context context;

    public DBmanager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "Constrator");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " integer primary key, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                PHONE + " TEXT," +
                ADDRESS + " TEXT)";
        db.execSQL(sqlQuery);
        Log.d(TAG, "onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, student.getmId());
        values.put(NAME, student.getmName());
        values.put(EMAIL, student.getmEmail());
        values.put(PHONE, student.getmPhone());
        values.put(ADDRESS, student.getmAddress());


        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "add student sucessfully !");

    }

    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmId(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmEmail(cursor.getString(2));
                student.setmPhone(cursor.getString(3));
                student.setmAddress(cursor.getString(4));
                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return listStudent;
    }

}
