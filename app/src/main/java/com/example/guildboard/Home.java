package com.example.guildboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("Rooms");

        String rooms[] = {"Room 1", "Room 2", "Room 3", "Room 4", "Room 5", "Room 6", "Room 7", "Room 8", "Room 9", "Room 10"};
        String admins[] = {"AAA", "BBB", "CCC", "DDD", "EEE", "AAA", "BBB", "CCC", "DDD", "EEE"};

        RecyclerView recyclerView = findViewById(R.id.rvRooms);

        RoomsAdapter adapter = new RoomsAdapter(this, rooms, admins);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void assignments(View view){
        Intent intent = new Intent(getBaseContext(), Assignments.class);
        startActivity(intent);
    }
}
