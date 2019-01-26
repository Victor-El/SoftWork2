package com.example.brainiac.softwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Auth extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("pin")) {
                    Toast.makeText(Auth.this, "Pin node Available", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Auth.this, "No Pin Node available, will make pin Node", Toast.LENGTH_SHORT).show();
                    myRef.child("pin").setValue("pin");
                    Toast.makeText(Auth.this, "Pin Node created successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Auth.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button submitPinBtn = (Button) findViewById(R.id.submit_pin);
        submitPinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("pin").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       String databasePin = dataSnapshot.getValue().toString();
                        EditText pinEditText = (EditText) findViewById(R.id.pin_view);
                        String pin = pinEditText.getText().toString().trim();

                        if (dataSnapshot.getValue().toString().equals(pin)) {
                            Intent i = new Intent(Auth.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Auth.this, "wrong Pin, Try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Auth.this, "error occurred", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
