package com.example.guildboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Status extends AppCompatActivity {

    RecyclerView recyclerView;
    String name = "Harshit C";
    String u = "1BM18IS040";

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> usn = new ArrayList<String>();
    StatusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        Integer n = 10, tot = n+6;
        Integer prec = (100*n)/tot;
        for(int i=0; i<n; i++) {
            names.add(name);
            usn.add(u);
        }

        String assName = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            assName = extras.getString("assName");
        }
        this.setTitle(assName);

        recyclerView = findViewById(R.id.rvStuds);
        TextView tv = findViewById(R.id.precentage);
        tv.setText(prec.toString()+"%");

        adapter = new StatusAdapter(this, names, usn);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
