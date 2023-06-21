package com.example.hifzrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyVH>{

    List<Student> students;

    public RecyclerViewAdapter(List<Student> students){
        this.students = students;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_card, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyVH holder, int position) {
        holder.data = students.get(position);
        holder.studentName.setText(holder.data.getName());
        holder.studentAge.setText(holder.data.getAge());
        holder.studentRoll.setText(holder.data.getId());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {

        TextView studentName, studentAge, studentRoll;

        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.viewName);
            studentAge = itemView.findViewById(R.id.viewAge);
            studentRoll = itemView.findViewById(R.id.viewAge);
        }
    }
}
