package com.example.yourpapyrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PieceActivity extends AppCompatActivity {

    TextView titleTextView2;
    TextView authorTextView2;
    TextView textTextView;
    TextView likesTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piece);
        getSupportActionBar().hide();

        titleTextView2 = findViewById(R.id.titleTextView2);
        authorTextView2 = findViewById(R.id.authorTextView2);
        textTextView = findViewById(R.id.textTextView);
        likesTextView2 = findViewById(R.id.likesTextView2);

        Intent intent = getIntent();

        int piecePosition = intent.getIntExtra("piecePosition", 0);
        Piece piece = PieceData.getPieceArrayList().get(piecePosition);

        titleTextView2.setText(piece.getTitle());
        authorTextView2.setText(piece.getAuthor());
        textTextView.setText(piece.getText());
        likesTextView2.setText("" + piece.getLikes().length());

    }
}