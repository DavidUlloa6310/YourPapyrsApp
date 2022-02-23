package com.example.yourpapyrs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<Piece> piecesArrayList;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {mListener = listener;}

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView authorTextView;
        public TextView likesTextView;

        public ExampleViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            likesTextView = itemView.findViewById(R.id.likesTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapter(ArrayList<Piece> pieceArrayList) {
        this.piecesArrayList = pieceArrayList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.piece_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Piece currentPiece = piecesArrayList.get(position);
        holder.titleTextView.setText(currentPiece.getTitle());
        holder.authorTextView.setText(currentPiece.getAuthor());
        holder.likesTextView.setText("" + currentPiece.getLikes().length());
    }

    @Override
    public int getItemCount() {
        return piecesArrayList.size();
    }

    public ArrayList<Piece> getPiecesArrayList() {
        return piecesArrayList;
    }
}
