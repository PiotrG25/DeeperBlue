package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece{


    public Bishop(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();

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
        return 30;
    }
}
