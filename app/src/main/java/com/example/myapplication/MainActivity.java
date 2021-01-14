package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import FirebaseDatabase.Demo;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference child= mRootRef.child("Name");
    TextView whoIsView;
    Button johnButton;
    Button jeffButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whoIsView=(TextView)findViewById(R.id.whoisView);
        johnButton=(Button)findViewById(R.id.johnButton);
        jeffButton=(Button)findViewById(R.id.jeffButton);
    }

    @Override
    protected void onStart(){
        super.onStart();
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text= snapshot.getValue(String.class);
                child.setValue(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        jeffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child.setValue("Jeff");
                whoIsView.setText("Jeff");
            }
        });
        johnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child.setValue("John");
                whoIsView.setText("John");
            }
        });
    }
}