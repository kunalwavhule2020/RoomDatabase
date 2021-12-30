package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<User> users;

    public myadapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.recid.setText(String.valueOf(users.get(position).getUid()));
        holder.recfname.setText(users.get(position).getFirstName());
        holder.reclname.setText(users.get(position).getLastName());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView recid,recfname,reclname;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            recid = itemView.findViewById(R.id.recid);
            recfname = itemView.findViewById(R.id.recfname);
            reclname = itemView.findViewById(R.id.reclname);
        }
    }
}
