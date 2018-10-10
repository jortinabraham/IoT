package com.sample.iot;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView setPoint,processVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View v = findViewById(R.id.view);
        v.setBackground(new CustomDrawable(getResources().getColor(R.color.grey),getResources().getColor(R.color.blue)));
        setPoint = findViewById(R.id.setPointValue);
        processVariable = findViewById(R.id.processVariableValue);
        final ProgressBar bar = findViewById(R.id.progressBar);


        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("IoT").child("values");
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                DataModel model = dataSnapshot.getValue(DataModel.class);
                if(bar.getVisibility() == View.VISIBLE){
                    bar.setVisibility(View.INVISIBLE);
                }

                int i = 0;
                if (model != null) {
                    setPoint.setText(String.valueOf(model.getSetpoint()));
                    processVariable.setText(String.valueOf(model.getProcess_variable()));
                    i = (int)(Float.parseFloat(model.getProcess_variable())*100);
                }
                Log.e("value",i+"");
                v.getBackground().setLevel(i);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}