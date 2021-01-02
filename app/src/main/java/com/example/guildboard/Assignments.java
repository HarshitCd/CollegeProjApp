package com.example.guildboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Assignments extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> ass = new ArrayList<String>();
    ArrayList<String> due = new ArrayList<String>();
    AssignmentsAdapter adapter;

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


        recyclerView = findViewById(R.id.rvAssignments);

        adapter = new AssignmentsAdapter(this, ass, due);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.join_option, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        System.out.println(id);
        switch (id) {
            case R.id.join:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                Context context =this;
                LinearLayout layout = new LinearLayout(context);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(50, 50, 50, 50);

                TextView tv1 = new TextView(context);
                tv1.setText("Assignment Name:");
                tv1.setTextSize(18);
                layout.addView(tv1);
// Add a TextView here for the "Title" label, as noted in the comments
                final EditText input = new EditText(context);
                input.setHint("Assignment name");
                layout.addView(input); // Notice this is an add method

                TextView tv2 = new TextView(context);
                tv2.setText("Due Date:");
                tv2.setTextSize(18);
                layout.addView(tv2);

// Add another TextView here for the "Description" label
                final DatePicker date = new DatePicker(context);
                date.setPadding(0, 10, 0, 0);
                layout.addView(date);

                builder.setView(layout);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String m_Text = input.getText().toString();
                        ass.add(m_Text.toString());
                        Integer y = date.getYear();
                        Integer m = date.getMonth()+1;
                        Integer d = date.getDayOfMonth();

                        String du = y+"/"+m+"/"+d;
                        due.add(du);
                        adapter.notifyData(ass, due);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
