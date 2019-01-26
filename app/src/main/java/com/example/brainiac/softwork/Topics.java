package com.example.brainiac.softwork;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.brainiac.softwork.MainActivity.itemSelected;

public class Topics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        CourseTopics ct = new CourseTopics();
        ListView topicsListView = (ListView) findViewById(R.id.topics_list_view);
        if (itemSelected == 0) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list_item, R.id.course_topics_list_view, ct.getMth101());
            topicsListView.setAdapter(arrayAdapter);
        } else if (itemSelected == 1) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list_item, R.id.course_topics_list_view, ct.getChm101());
            topicsListView.setAdapter(arrayAdapter);
        } else if (itemSelected == 2) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list_item, R.id.course_topics_list_view, ct.getPhy101());
            topicsListView.setAdapter(arrayAdapter);
        } else if (itemSelected == 3) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list_item, R.id.course_topics_list_view, ct.getEng103());
            topicsListView.setAdapter(arrayAdapter);
        } else {
            final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("No entries yet");
            alertBuilder.setMessage("Come back later");
            alertBuilder.setCancelable(false);
            alertBuilder.setIcon(android.R.drawable.stat_sys_warning);
            alertBuilder.setPositiveButton("Go Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            });
            alertBuilder.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            alertBuilder.show();
        }
        topicsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
