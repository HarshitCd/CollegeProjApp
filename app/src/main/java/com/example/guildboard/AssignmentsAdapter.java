package com.example.guildboard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.RoomsViewHolder> {

    Context context;
    String ass[], due[];

    public AssignmentsAdapter(Context ct, String[] a, String[] d){
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
    public void onBindViewHolder(@NonNull RoomsViewHolder holder, int position) {
        holder.assignment.setText(ass[position]);
        holder.duedate.setText(due[position]);
    }

    @Override
    public int getItemCount() {
        return ass.length;
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

