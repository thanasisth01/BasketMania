package com.example.karta_agona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class R4recyclerAdapter extends RecyclerView.Adapter<R4recyclerAdapter.MyViewHolder> {

    private ArrayList<R4Event> eventList;
    public R4recyclerAdapter(ArrayList<R4Event> eventList){
        this.eventList =eventList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView playerNameText;
        private TextView eventTxt;
        private TextView opponentsNameText;
        private TextView timeTxt;

        public MyViewHolder(final View view){
            super(view);
            playerNameText=view.findViewById(R.id.player_name);
            eventTxt= view.findViewById(R.id.event_type);
            opponentsNameText = view.findViewById(R.id.opp_name);
            timeTxt= view.findViewById(R.id.editTextTime);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = eventList.get(position).getPlayerName();
        holder.playerNameText.setText(name);
        String event = eventList.get(position).getEventType();
        holder.eventTxt.setText(event);
        String opponent = eventList.get(position).getOpponentsName();
        holder.opponentsNameText.setText(opponent);

        Timestamp ts = eventList.get(position).getEventTime();
        Time time = new Time(ts.getTime());
        holder.timeTxt.setText(time.toString());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
