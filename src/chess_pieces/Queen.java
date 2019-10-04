package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece{


    public Queen(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();

        // Rook like
        for(int i = xPos + 1; i < 8 && (freeSpace[i][yPos] || opponents[i][yPos]); i++){
            moves.add(new int []{i, yPos});
        }
        for(int i = xPos - 1; i >= 0 && (freeSpace[i][yPos] || opponents[i][yPos]); i--){
            moves.add(new int []{i, yPos});
        }
        for(int j = yPos + 1; j < 8 && (freeSpace[xPos][j] || opponents[xPos][j]); j++){
            moves.add(new int []{xPos, j});
        }
        for(int j = yPos - 1; j >= 0 && (freeSpace[xPos][j] || opponents[xPos][j]); j--){
            moves.add(new int []{xPos, j});
        }

        // Bishop like
        for(int i = xPos + 1, j = yPos + 1; i < 8 && j < 8 && (freeSpace[i][j] || opponents[i][j]); i++, j++){
            moves.add(new int []{i, j});
        }
        for(int i = xPos + 1, j = yPos - 1; i < 8 && j >= 0 && (freeSpace[i][j] || opponents[i][j]); i++, j--){
            moves.add(new int []{i, j});
        }
        for(int i = xPos - 1, j = yPos + 1; i >= 0 && j < 8 && (freeSpace[i][j] || opponents[i][j]); i--, j++){
            moves.add(new int []{i, j});
        }
        for(int i = xPos - 1, j = yPos - 1; i >= 0 && j >= 0 && (freeSpace[i][j] || opponents[i][j]); i--, j--){
            moves.add(new int []{i, j});
        }

        return moves;
    }

    @Override
    public int points() {
        return 90;
    }
}
