package com.example.brainiac.softwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private AdView mAdView;
    public static int itemSelected;
    static String listText = "";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myRef.setValue("Hello, World!");
//        mAdView = (AdView) findViewById(R.id.adView);
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("MTH101", "Elementary Mathematics 1"));
        courses.add(new Course("CHM101", "General Chemistry 1"));
        courses.add(new Course("PHY101", "General Physics 1"));
        courses.add(new Course("ENG103", "Engineering Drawing 1"));
        courses.add(new Course("TIPS", "Study and examination tips"));

        CourseAdapter adapter = new CourseAdapter(MainActivity.this, courses);

        final GridView courseGrid = (GridView) findViewById(R.id.topic_grid);

        courseGrid.setAdapter(adapter);

        courseGrid.animate();
        courseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                TextView tv = (TextView) view.findViewById(R.id.course_name);
                listText = tv.getText().toString();
                //listText = (courseGrid.getItemAtPosition(i).toString());
                Toast.makeText(MainActivity.this, listText , Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        itemSelected = i;
                        startActivity(new Intent(MainActivity.this, Topics.class));
                        break;
                    case 1:
                        itemSelected = i;
                        startActivity(new Intent(MainActivity.this, Topics.class));
                        break;
                    case 2:
                        itemSelected = i;
                        startActivity(new Intent(MainActivity.this, Topics.class));
                        break;
                    case 3:
                        itemSelected = i;
                        startActivity(new Intent(MainActivity.this, Topics.class));
                        break;
                    case 4:
                        itemSelected = i;
                        startActivity(new Intent(MainActivity.this, Topics.class));
                        break;
                    default:
                        itemSelected = 0;

                }
                Log.d("Intent", Integer.toString(i));
            }
        });

       // topicGrid.setAdapter(topicAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //MainActivity.this.onDestroy();
        MainActivity.this.finish();
    }
}
