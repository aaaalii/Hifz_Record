package com.example.hifzrecord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyVH>{

    List<Student> students;
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

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
        holder.studentsRoll.setText(Integer.toString(holder.data.getId()));
        holder.studentAge.setText(holder.data.getAge());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView studentName, studentAge, studentsRoll;
        Student data;

        public MyVH(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        int id = students.get(position).getId();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(id);
                        }
                    }
                }
            });

            studentName = itemView.findViewById(R.id.viewName);
            studentsRoll = itemView.findViewById(R.id.viewRoll2);
            studentAge = itemView.findViewById(R.id.viewAge);
        }
    }

    interface OnItemClickListener {
        void onItemClick(int id);
    }
}
