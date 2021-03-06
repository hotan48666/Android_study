package com.example.noteapp.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.entities.Note;

import java.util.List;

public class NoteAdpter extends RecyclerView.Adapter<NoteAdpter.NoteViewHolder> {

    private List<Note> notes;

    public NoteAdpter(List<Note> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_note,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle, textSubtitle, textDateTime;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitle);
            textSubtitle = itemView.findViewById(R.id.textSubtitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);


        }


        void setNote(Note note){

            textTitle.setText(note.getTitle());
            if(note.getSubtitle().trim().isEmpty()){
                textTitle.setVisibility(View.GONE);

            }else {
                textTitle.setText(note.getSubtitle());
            }
            textDateTime.setText(note.getDateTime());
        }
    }
}
