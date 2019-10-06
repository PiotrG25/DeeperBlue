package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece{

    //todo check
    //todo castling
    // Castling may only be performed if the king and rook involved have never previously been moved in the game, if the king is not in check, if the king would not travel through or into check, and if there are no pieces between the rook and the king


    public King(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();

        for(int i = xPos - 1; i <= xPos + 1; i++){
            for(int j = yPos - 1; j <= yPos + 1; j++){
                if((i != xPos || j != yPos) && 0 <= i && i < 8 && 0 <= j && j < 8 && (freeSpace[i][j] || opponents[i][j])){
                    moves.add(new int []{xPos + i, yPos + j});
                }
            }
        }

        return moves;
    }

    @Override
    public int points() {
        return 999; // because reasons
    }
}
