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

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.RoomsViewHolder> {

    Context context;
    ArrayList<String> ass, due;

    public AssignmentsAdapter(Context ct, ArrayList<String> a, ArrayList<String> d){
        context = ct;
        ass = a;
        due = d;
    }

    @NonNull
    @Override
    public RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.assignments_layout, parent, false);

        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsViewHolder holder, final int position) {
        holder.assignment.setText(ass.get(position));
        holder.duedate.setText(due.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Status.class);
                intent.putExtra("assName", ass.get(position));
                context.startActivity(intent);
            }
        });
    }

    public void notifyData(ArrayList<String> a, ArrayList<String> d) {
        ass = a;
        due = d;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ass.size();
    }

    public class RoomsViewHolder extends RecyclerView.ViewHolder {

        TextView assignment, duedate;

        public RoomsViewHolder(@NonNull View itemView) {
            super(itemView);
            assignment = itemView.findViewById(R.id.tvAss);
            duedate = itemView.findViewById(R.id.tvDue);

        }
    }
}

