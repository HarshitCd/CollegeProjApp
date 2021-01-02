package com.example.guildboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<String> rooms = new ArrayList<String>();
    ArrayList<String> admins = new ArrayList<String>();
    RoomsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setTitle("Rooms");

        recyclerView = findViewById(R.id.rvRooms);

        adapter = new RoomsAdapter(this, rooms, admins);
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
                builder.setTitle("Room Code:");

                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String m_Text = input.getText().toString();
                        Toast.makeText(getApplicationContext(), m_Text,
                                Toast.LENGTH_SHORT ).show();
                        rooms.add(m_Text.toString());
                        admins.add("AAA");
                        adapter.notifyData(rooms, admins);

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
