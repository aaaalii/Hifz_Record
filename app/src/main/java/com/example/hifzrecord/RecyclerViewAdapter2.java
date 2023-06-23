package com.example.hifzrecord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyVHo>{

    List<StudentFullRecord> students;
    private RecyclerViewAdapter.OnItemClickListener listener;

    public void setOnItemClickListener(RecyclerViewAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }


    public RecyclerViewAdapter2(List<StudentFullRecord> students){
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter2.MyVHo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.full_record, parent, false);
        return new RecyclerViewAdapter2.MyVHo(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.MyVHo holder, int position) {
        holder.data = students.get(position);
        holder.studentName.setText(holder.data.getName());
        holder.studentAge.setText(holder.data.getAge());
        holder.studentRoll.setText(Integer.toString(holder.data.getId()));
        holder.sabaq.setText("Surah no.: " + holder.data.getSabaqSurah()+ "\nStarting ayat: " + holder.data.getSabaqStart() + "\nEnding ayat:" + holder.data.getSabaqEnd());
        holder.sabqi.setText(holder.data.getSabqiSurah());
        holder.manzil.setText(holder.data.getManzilSurah());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyVHo extends RecyclerView.ViewHolder {

        TextView studentName, studentAge, studentRoll, sabaq, sabqi, manzil;

        StudentFullRecord data;

        public MyVHo(@NonNull View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.viewName);
            studentAge = itemView.findViewById(R.id.viewAge);
            studentRoll = itemView.findViewById(R.id.viewRoll);
            sabaq = itemView.findViewById(R.id.sabaq);
            sabqi = itemView.findViewById(R.id.sabqi);
            manzil = itemView.findViewById(R.id.manzil);
        }
    }
}
