import chess_pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> chessPieces = new ArrayList<>();
        setupBoard(chessPieces);

    }

    private static void setupBoard(List<ChessPiece> chessPieces){
        for(int i = 0; i < 8; i++){
            chessPieces.add(new Pawn(i, 1, true));
            chessPieces.add(new Pawn(i, 6, false));
        }
        chessPieces.add(new Rook(0, 0, true));
        chessPieces.add(new Rook(7, 0, true));
        chessPieces.add(new Rook(0, 7, false));
        chessPieces.add(new Rook(7, 7, false));

        chessPieces.add(new King(1, 0, true));
        chessPieces.add(new King(6, 0, true));
        chessPieces.add(new King(1, 7, false));
        chessPieces.add(new King(6, 7, false));

        chessPieces.add(new Bishop(2, 0, true));
        chessPieces.add(new Bishop(5, 0, true));
        chessPieces.add(new Bishop(2, 7, false));
        chessPieces.add(new Bishop(5, 7, false));

        chessPieces.add(new Queen(3, 0, true));
        chessPieces.add(new Queen(3, 7, false));

        chessPieces.add(new King(5, 0, true));
        chessPieces.add(new King(5, 7, false));
    }
}
