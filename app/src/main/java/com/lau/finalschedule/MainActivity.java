package com.lau.finalschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        ListView list;
        Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listview); //linking the list view
        ArrayList <String> courses = new ArrayList<>();
        ArrayList <String> links = new ArrayList<>();
        

        try {
            SQLiteDatabase sql = this.openOrCreateDatabase("coursesdb", MODE_PRIVATE, null);
//             sql.execSQL("CREATE Table IF NOT EXISTS courses (course_name VARCHAR, link VARCHAR)");
//             sql.execSQL("INSERT INTO courses(course_name, link) VALUES ('Mobile Computing', 'https://ionicframework.com/'), ('Software Engineering', 'https://www.edx.org/learn/software-engineering'),('Parallel programming', 'https://www.coursera.org/learn/scala-parallel-programming'), ('Discrete Mathematics', 'https://www.codecademy.com/learn/discrete-math')");

            Cursor c = sql.rawQuery("SELECT * FROM courses", null);
            int course_name_index = c.getColumnIndex("course_name");
            int link_index = c.getColumnIndex("link");

            while (c.moveToNext()) {
                courses.add(c.getString(course_name_index));
                links.add(c.getString(link_index));

            }
            ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, courses);
            list.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long x) {
                intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("studylink", links.get(i)); //sending data from this activity to the other, the link the user clicks on
                startActivity(intent);
            }
        });










    }
}