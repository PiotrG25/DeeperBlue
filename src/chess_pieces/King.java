package chess_pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece{


    public King(int xPos, int yPos, boolean isWhite) {
        super(xPos, yPos, isWhite);
    }


    @Override
    public List<int[]> getPossibleMoves(boolean[][] freeSpace, boolean[][] opponents) {
        List<int []> moves = new ArrayList<>();

        for(int i = xPos - 1; i <= xPos + 1; i++){
            for(int j = yPos - 1; j <= yPos + 1; j++){
                if((i != xPos || j != yPos) && 0 <= i && i < 8 && 0 <= j && j < 8 && (freeSpace[i][j] || opponents[i][j])){
                    moves.add(new int []{i, j});
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
