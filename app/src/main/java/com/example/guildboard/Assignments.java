package com.example.guildboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Assignments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        String roomName="";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            roomName = extras.getString("roomName");
        }
        this.setTitle(roomName + " Assignments");

        String ass[] = {"Ass 1", "Ass 2", "Ass 3", "Ass 4", "Ass 5"};
        String due[] = {"01/01/2021", "02/01/2021", "03/01/2021", "04/01/2021", "05/01/2021"};

        RecyclerView recyclerView = findViewById(R.id.rvAssignments);

        AssignmentsAdapter adapter = new AssignmentsAdapter(this, ass, due);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
