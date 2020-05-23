package com.example.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class itemadapter extends RecyclerView.Adapter<itemadapter.ViewHolder> {
    private ArrayList<Attendance> listitem;

    public itemadapter(Context ctx, ArrayList<Attendance> dataModelArrayList){

       LayoutInflater inflater = LayoutInflater.from(ctx);
        this.listitem = dataModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(
                parent.getContext()
        );
        View v =inflater.inflate(R.layout.items,parent ,false);
        ViewHolder vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Attendance myattendence= listitem.get(position);
        holder.tv1.setText(myattendence.getClassName());
        holder.tv2.setText(myattendence.getTotalLectures().toString());
        holder.tv3.setText(myattendence.getPresent().toString());
        holder.tv4.setText(myattendence.getAbsent().toString());
        holder.tv5.setText(myattendence.getLate().toString());
        holder.tv6.setText(myattendence.getSick().toString());
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView tv1,tv2,tv3,tv4,tv5,tv6;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 =(TextView) itemView.findViewById(R.id.tv1);
            tv2 =(TextView) itemView.findViewById(R.id.tv2);
            tv3 =(TextView) itemView.findViewById(R.id.tv3);
            tv4 =(TextView) itemView.findViewById(R.id.tv4);
            tv5 =(TextView) itemView.findViewById(R.id.tv5);
            tv6 =(TextView) itemView.findViewById(R.id.tv6);

        }
    }


    }

