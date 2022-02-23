package com.example.yourpapyrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button viewPoems;
    PieceDataService pieceDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        viewPoems = findViewById(R.id.viewPoemsButton);

        viewPoems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PiecesListActivity.class);
                startActivity(intent);
            }
        });

        pieceDataService = new PieceDataService(this);
        pieceDataService.getPieces(new PieceDataService.GetPieceListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
                System.out.println(message);
                PieceData.setPieceArrayList(new ArrayList<Piece>());
            }

            @Override
            public void onResponse(ArrayList<Piece> pieces) {
                PieceData.setPieceArrayList(pieces);
            }
        });
    }
}