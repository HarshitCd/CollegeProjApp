package com.example.guildboard;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    Context context;
    ArrayList<String> names, usn;

    public StatusAdapter(Context ct, ArrayList<String> r, ArrayList<String> a){
        context = ct;
        names = r;
        usn = a;
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rooms_layout, parent, false);

        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, final int position) {
        holder.n.setText(names.get(position));
        holder.u.setText(usn.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    public class StatusViewHolder extends RecyclerView.ViewHolder {

        TextView n, u;

        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);
             n = itemView.findViewById(R.id.tvRoomName);
             u = itemView.findViewById(R.id.tvRoomAdmin);

        }
    }


}

