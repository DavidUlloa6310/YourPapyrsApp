package com.example.yourpapyrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class PiecesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private PieceDataService pieceDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieces_list);

        getSupportActionBar().hide();

        buildRecyclerView();
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        exampleAdapter = new ExampleAdapter(PieceData.getPieceArrayList());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);

        exampleAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), PieceActivity.class);
                intent.putExtra("piecePosition", position);
                startActivity(intent);
            }
        });
    }
}