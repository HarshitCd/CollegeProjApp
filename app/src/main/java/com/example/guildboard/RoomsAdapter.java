package com.example.guildboard;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder> {

    Context context;
    ArrayList<String> rooms, admins;

    public RoomsAdapter(Context ct, ArrayList<String> r, ArrayList<String> a){
        context = ct;
        rooms = r;
        admins = a;
    }

    @NonNull
    @Override
    public RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rooms_layout, parent, false);

        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsViewHolder holder, final int position) {
        holder.room.setText(rooms.get(position));
        holder.admin.setText(admins.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Assignments.class);
                intent.putExtra("roomName", rooms.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public void notifyData(ArrayList<String> r, ArrayList<String> a) {
        rooms = r;
        admins = a;
        notifyDataSetChanged();
    }

    public class RoomsViewHolder extends RecyclerView.ViewHolder {

        TextView room, admin;

        public RoomsViewHolder(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.tvRoomName);
            admin = itemView.findViewById(R.id.tvRoomAdmin);

        }
    }


}

