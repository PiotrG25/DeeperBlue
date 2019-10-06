package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece{

    //todo castling
    // Castling may only be performed if the king and rook involved have never previously been moved in the game, if the king is not in check, if the king would not travel through or into check, and if there are no pieces between the rook and the king


    public Rook(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();

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
        return moves;
    }

    @Override
    public int points() {
        return 40;
    }
}
