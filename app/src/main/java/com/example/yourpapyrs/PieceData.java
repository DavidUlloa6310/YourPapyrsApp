package com.example.yourpapyrs;

import java.util.ArrayList;

public class PieceData {
    private static ArrayList<Piece> pieceArrayList;

    public static ArrayList<Piece> getPieceArrayList() {
        return pieceArrayList;
    }

    public static void setPieceArrayList(ArrayList<Piece> pieceArrayList) {
        PieceData.pieceArrayList = pieceArrayList;
    }
}
